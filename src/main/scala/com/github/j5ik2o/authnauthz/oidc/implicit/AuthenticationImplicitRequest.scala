package com.github.j5ik2o.authnauthz.oidc.`implicit`

import com.github.j5ik2o.authnauthz.base.AuthorizationImplicitBaseRequest
import com.github.j5ik2o.authnauthz.oauth2.{ AbstractAuthorizationRequest, ClientId, RedirectURI, State }
import com.github.j5ik2o.authnauthz.oidc.{ Nonce, ResponseTypes, Scopes }

final case class AuthenticationImplicitRequest(
    override val responseTypes: ResponseTypes,
    override val clientId: ClientId,
    override val redirectURI: RedirectURI,
    override val scopes: Scopes,
    override val state: Option[State],
    nonce: Nonce
) extends AbstractAuthorizationRequest(responseTypes, clientId, redirectURI, scopes, state)
    with AuthorizationImplicitBaseRequest
