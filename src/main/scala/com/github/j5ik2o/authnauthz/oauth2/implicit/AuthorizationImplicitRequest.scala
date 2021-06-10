package com.github.j5ik2o.authnauthz.oauth2.`implicit`

import com.github.j5ik2o.authnauthz.base
import com.github.j5ik2o.authnauthz.oauth2._

final case class AuthorizationImplicitRequest(
    override val responseTypes: ResponseTypes,
    override val clientId: ClientId,
    override val redirectURI: RedirectURI,
    override val scopes: Scopes,
    override val state: Option[State]
) extends AbstractAuthorizationRequest(responseTypes, clientId, redirectURI, scopes, state)
    with base.AuthorizationImplicitBaseRequest {
  require(responseTypes.values.contains(ResponseType.Token))
}
