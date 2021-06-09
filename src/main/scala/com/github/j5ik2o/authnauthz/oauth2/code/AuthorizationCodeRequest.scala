package com.github.j5ik2o.authnauthz.oauth2.code

import com.github.j5ik2o.authnauthz.{ ClientId, RedirectURI, State }
import com.github.j5ik2o.authnauthz.oauth2.{ AbstractAuthorizationRequest, ResponseType, ResponseTypes, Scopes }

final case class AuthorizationCodeRequest(
    override val responseTypes: ResponseTypes,
    override val clientId: ClientId,
    override val redirectURI: RedirectURI,
    override val scopes: Scopes,
    override val state: State
) extends AbstractAuthorizationRequest(responseTypes, clientId, redirectURI, scopes, state) {
  require(responseTypes.values.contains(ResponseType.Code))
}
