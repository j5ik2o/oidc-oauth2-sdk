package com.github.j5ik2o.authnauthz.oauth2.code

import com.github.j5ik2o.authnauthz.RequestHandler
import com.github.j5ik2o.authnauthz.oauth2._

final case class AuthorizationCodeRequest(
    responseTypes: ResponseTypes,
    clientId: ClientId,
    redirectURI: RedirectURI,
    scopes: Scopes,
    state: Option[State]
) {
  require(responseTypes.values.contains(ResponseType.Code))
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
