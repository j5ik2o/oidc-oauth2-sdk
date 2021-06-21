package com.github.j5ik2o.authnauthz.oauth2.code

import com.github.j5ik2o.authnauthz.oauth2.{ Client, ErrorType, RedirectUri, State }

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
