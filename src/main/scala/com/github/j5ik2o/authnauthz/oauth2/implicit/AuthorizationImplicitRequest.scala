package com.github.j5ik2o.authnauthz.oauth2.`implicit`

import com.github.j5ik2o.authnauthz.oauth2._

final case class AuthorizationImplicitRequest(
    responseTypes: ResponseTypes,
    clientId: ClientId,
    redirectURI: RedirectUri,
    scopes: Scopes,
    state: Option[State]
) {
  require(responseTypes.values.contains(ResponseType.Token))
}
