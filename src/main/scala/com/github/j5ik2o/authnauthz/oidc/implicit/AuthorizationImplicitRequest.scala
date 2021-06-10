package com.github.j5ik2o.authnauthz.oidc.`implicit`

import com.github.j5ik2o.authnauthz.{ ClientId, RedirectURI, State }
import com.github.j5ik2o.authnauthz.oidc.{ AbstractAuthorizationRequest, Nonce, ResponseTypes, Scopes }

final case class AuthorizationImplicitRequest(
    override val responseTypes: ResponseTypes,
    override val clientId: ClientId,
    override val redirectURI: RedirectURI,
    override val scopes: Scopes,
    override val state: Option[State],
    nonce: Nonce
) extends AbstractAuthorizationRequest(responseTypes, clientId, redirectURI, scopes, state)
