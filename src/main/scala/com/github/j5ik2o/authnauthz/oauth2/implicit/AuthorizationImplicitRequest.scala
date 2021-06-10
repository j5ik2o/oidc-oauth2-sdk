package com.github.j5ik2o.authnauthz.oauth2.`implicit`

import com.github.j5ik2o.authnauthz.oauth2.{
  AbstractAuthorizationRequest,
  ClientId,
  RedirectURI,
  ResponseType,
  ResponseTypes,
  Scopes,
  State
}

final case class AuthorizationImplicitRequest(
    override val responseTypes: ResponseTypes,
    override val clientId: ClientId,
    override val redirectURI: RedirectURI,
    override val scopes: Scopes,
    override val state: Option[State]
) extends AbstractAuthorizationRequest(responseTypes, clientId, redirectURI, scopes, state) {
  require(responseTypes.values.contains(ResponseType.Token))
}
