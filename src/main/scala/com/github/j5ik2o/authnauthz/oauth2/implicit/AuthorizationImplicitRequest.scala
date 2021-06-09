package com.github.j5ik2o.authnauthz.oauth2.`implicit`

import com.github.j5ik2o.authnauthz.oauth2.{ AbstractAuthorizationRequest, ResponseType, ResponseTypes, Scopes }
import com.github.j5ik2o.authnauthz.{ ClientId, RedirectURI, State }

final case class AuthorizationImplicitRequest(
    override val responseTypes: ResponseTypes,
    override val clientId: ClientId,
    override val redirectURI: RedirectURI,
    override val scopes: Scopes,
    override val state: State
) extends AbstractAuthorizationRequest(responseTypes, clientId, redirectURI, scopes, state) {
  require(responseTypes.values.contains(ResponseType.Token))
}
