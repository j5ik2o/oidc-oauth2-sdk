package com.github.j5ik2o.authnauthz.oauth2.code

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
