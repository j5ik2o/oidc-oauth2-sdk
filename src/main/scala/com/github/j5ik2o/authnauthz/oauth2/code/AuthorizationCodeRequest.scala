package com.github.j5ik2o.authnauthz.oauth2.code

import com.github.j5ik2o.authnauthz.RequestHandler
import com.github.j5ik2o.authnauthz.oauth2._
import enumeratum._

sealed trait ValidateError extends EnumEntry

object ValidateError extends Enum[ValidateError] {
  override def values: IndexedSeq[ValidateError] = findValues
  case object NotFoundRedirectUri extends ValidateError
  case object NotMatchRedirectUri extends ValidateError
}

final case class AuthorizationCodeRequest(
    responseTypes: ResponseTypes,
    clientId: ClientId,
    redirectUri: Option[RedirectUri],
    scopes: Scopes,
    state: Option[State]
) {
  require(responseTypes.values.contains(ResponseType.Code))

  def validateRedirectUri(client: Client): Either[ValidateError, Unit] = {
    if (client.mustRedirectUri) {
      if (redirectUri.isEmpty) {
        Left(ValidateError.NotFoundRedirectUri)
      } else {
        if (!client.redirectUris.toVector.contains(redirectUri.get)) {
          Left(ValidateError.NotMatchRedirectUri)
        } else {
          Right(())
        }
      }
    } else {
      Right(())
    }
  }
}

object AuthorizationCodeRequest {

  implicit object AuthorizationCodeRequestHandler
      extends RequestHandler[AuthorizationCodeRequest, AuthorizationCodeRequest, AuthorizationCodeResponse] {

    override type Output[A] = Either[Exception, A]

    override def execute(
        self: AuthorizationCodeRequest,
        req: AuthorizationCodeRequest
    ): Output[AuthorizationCodeResponse] = ???
  }
}
