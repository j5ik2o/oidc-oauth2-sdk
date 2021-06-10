package com.github.j5ik2o.authnauthz.oidc.`implicit`

import com.github.j5ik2o.authnauthz.oauth2.AbstractAuthorizationRequest
import com.github.j5ik2o.authnauthz.oidc.{ Nonce, ResponseTypes, Scopes }
import com.github.j5ik2o.authnauthz.{ ClientId, RedirectURI, State }

final case class AuthorizationImplicitRequest(
    override val responseTypes: ResponseTypes,
    override val clientId: ClientId,
    override val redirectURI: RedirectURI,
    override val scopes: Scopes,
    override val state: Option[State],
    nonce: Nonce
) extends AbstractAuthorizationRequest(responseTypes, clientId, redirectURI, scopes, state)
