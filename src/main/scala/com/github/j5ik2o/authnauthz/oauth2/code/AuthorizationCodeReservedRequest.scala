package com.github.j5ik2o.authnauthz.oauth2.code

import cats.Id
import cats.implicits._
import com.github.j5ik2o.authnauthz.RequestHandler
import com.github.j5ik2o.authnauthz.oauth2._

import java.text.ParseException
import java.time.Instant
import scala.util.{ Failure, Success, Try }

final case class AuthorizationCodeRequest(
    responseTypes: Set[String],
    clientId: String,
    redirectUri: Option[String],
    scopes: Set[String],
    state: Option[String]
) {
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
)

object AuthorizationCodeRequest {

  implicit object AuthorizationCodeRequestHandler
      extends RequestHandler[
        AuthorizationCodeRequest,
        (Option[ReservedAuthorization], AuthorizationCodeReservedResponse)
      ] {

    override type Output[A] = Id[A]

    override def execute(
        self: AuthorizationCodeRequest,
        client: Client
    ): Output[(Option[ReservedAuthorization], AuthorizationCodeReservedResponse)] = {
      self
        .validate(client, forceFull = false) match {
        case Right(valid) =>
          val refKey = RefKey()
          val reservedAuthorization = ReservedAuthorization(
            ReservedAuthorizationId(refKey),
            client.clientId,
            valid.responseTypes,
            valid.redirectUri.get,
            valid.scopes,
            valid.state,
            Instant.now()
          )
          val response = AuthorizationCodeSuccessfulResponse(
            BehaviorType.Interaction,
            refKey,
            client.clientId,
            client.clientName,
            valid.redirectUri.get,
            valid.scopes,
            valid.state
          )
          (Some(reservedAuthorization), response)
        case Left(ex) =>
          val response =
            AuthorizationCodeFailureResponse(
              BehaviorType.BadRequest,
              client.clientId,
              self.redirectUri,
              ex.errorType,
              Some(ex.getMessage),
              None,
              ex.state
            )
          (None, response)
      }
    }
  }
}
