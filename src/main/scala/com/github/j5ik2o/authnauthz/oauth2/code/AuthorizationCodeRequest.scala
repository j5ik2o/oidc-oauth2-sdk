package com.github.j5ik2o.authnauthz.oauth2.code

import cats.Id
import cats.implicits._
import com.github.j5ik2o.authnauthz.RequestHandler
import com.github.j5ik2o.authnauthz.oauth2._

import java.text.ParseException
import java.time.Instant
import scala.util.{ Failure, Success, Try }

sealed abstract class ValidationException(
    val errorType: ErrorType,
    message: String,
    val state: Option[State],
    cause: Option[Throwable]
) extends Exception(message, cause.orNull)

object ValidationException {

  case class ClientIdNotMatchException(
      clientId: String,
      override val state: Option[State],
      cause: Option[Throwable] = None
  ) extends ValidationException(
        ErrorType.InvalidRequest,
        s"ClientId is not match. clientId = $clientId",
        state,
        cause
      )

  case class ResponseTypeInvalidException(
      responseType: String,
      override val state: Option[State],
      cause: Option[Throwable] = None
  ) extends ValidationException(
        ErrorType.InvalidRequest,
        s"ResponseType is invalid. responseType = $responseType",
        state,
        cause
      )

  case class RedirectUriNotFoundException(
      client: Client,
      redirectUri: Option[String],
      override val state: Option[State],
      cause: Option[Throwable] = None
  ) extends ValidationException(
        ErrorType.InvalidRequest,
        s"RedirectUri is not found. clientId = ${client.clientId}, redirectUri = $redirectUri",
        state,
        cause
      )

  case class RedirectUriInvalidException(
      client: Client,
      redirectUri: String,
      override val state: Option[State],
      cause: Option[Throwable] = None
  ) extends ValidationException(
        ErrorType.InvalidRequest,
        s"RedirectUri is invalid. clientId = ${client.clientId}, redirectUri = $redirectUri",
        state,
        cause
      )

  case class RedirectUriNotMatchException(
      client: Client,
      redirectUri: RedirectUri,
      override val state: Option[State],
      cause: Option[Throwable] = None
  ) extends ValidationException(
        ErrorType.InvalidRequest,
        s"RedirectUri is not match. clientId = ${client.clientId}, redirectUri = $redirectUri",
        state,
        cause
      )

  case class ValidateExceptions(
      exs: Vector[ValidationException],
      override val state: Option[State],
      cause: Option[Throwable] = None
  ) extends ValidationException(ErrorType.InvalidRequest, s"Exceptions. exs = $exs", state, cause)

}

sealed trait AuthorizationCodeRequest

case class AuthorizationCodeRequestPlain(
    responseTypes: Set[String],
    clientId: String,
    redirectUri: Option[String],
    scopes: Set[String],
    state: Option[String]
) extends AuthorizationCodeRequest {
  type ValidationResult[A] = Either[ValidationException, A]

  protected def validateState: ValidationResult[Option[State]] = {
    Right(state.map(State))
  }

  protected def validateScopes(state: Option[State]): ValidationResult[Scopes] = {
    val ss = scopes.map(Scope)
    Right(Scopes(ss))
  }

  protected def validateResponseTypes(state: Option[State]): ValidationResult[ResponseTypes] = {
    responseTypes
      .foldLeft(Try(Vector.empty[ResponseType])) { case (result, element) =>
        for {
          r <- result
          e <- Try(ResponseType.withName(element))
        } yield r :+ e
      }.map(ResponseTypes(_: _*)) match {
      case Success(value)                   => Right(value)
      case Failure(ex: ValidationException) => Left(ex)
    }
  }

  protected def validateClientId(client: Client, state: Option[State]): ValidationResult[ClientId] = {
    val cid = ClientId.of(clientId)
    if (client.clientId == cid) {
      Right(cid)
    } else {
      Left(ValidationException.ClientIdNotMatchException(clientId, state))
    }
  }

  protected[authnauthz] def validateRedirectUri(
      client: Client,
      forceFull: Boolean,
      state: Option[State]
  ): ValidationResult[Option[RedirectUri]] = {
    if (client.mustRedirectUri) {
      redirectUri match {
        case None =>
          Left(ValidationException.RedirectUriNotFoundException(client, redirectUri, state))
        case Some(redirectUriAsString) =>
          RedirectUri.parse(redirectUriAsString) match {
            case Right(redirectUri) =>
              if (!client.redirectUris.contains(redirectUri, forceFull))
                Left(ValidationException.RedirectUriNotMatchException(client, redirectUri, state))
              else
                Right(Some(redirectUri))
            case Left(ex: ParseException) =>
              Left(ValidationException.RedirectUriInvalidException(client, redirectUriAsString, state, Some(ex)))
          }
      }
    } else
      Right(None)
  }

  def validate(client: Client, forceFull: Boolean): ValidationResult[AuthorizationCodeRequestValid] = {
    validateState.flatMap { state =>
      (
        validateClientId(client, state),
        validateResponseTypes(state),
        validateRedirectUri(client, forceFull, state),
        validateScopes(state)
      ).mapN { case (clientId, responseTypes, redirectUris, scopes) =>
        AuthorizationCodeRequestValid(responseTypes, clientId, redirectUris, scopes, state)
      }
    }
  }

}

final case class AuthorizationCodeRequestValid(
    responseTypes: ResponseTypes,
    clientId: ClientId,
    redirectUri: Option[RedirectUri],
    scopes: Scopes,
    state: Option[State]
) extends AuthorizationCodeRequest

object AuthorizationCodeRequest {

  implicit object AuthorizationCodeRequestHandler
      extends RequestHandler[
        AuthorizationCodeRequestPlain,
        (Option[ReservedAuthorization], AuthorizationCodeResponse)
      ] {

    override type Output[A] = Id[A]

    override def execute(
        self: AuthorizationCodeRequestPlain,
        client: Client
    ): Output[(Option[ReservedAuthorization], AuthorizationCodeResponse)] = {
      self
        .validate(client, forceFull = false) match {
        case Right(valid) =>
          val code = AuthorizationCode()
          val reservedAuthorization = ReservedAuthorization(
            code,
            client.clientId,
            valid.responseTypes,
            valid.redirectUri.get,
            valid.scopes,
            valid.state,
            Instant.now()
          )
          val response = AuthorizationSuccessfulCodeResponse(code, valid.state)
          (Some(reservedAuthorization), response)
        case Left(ex) =>
          val response = AuthorizationFailureCodeResponse(ex.errorType, Some(ex.getMessage), None, ex.state)
          (None, response)
      }
    }
  }
}
