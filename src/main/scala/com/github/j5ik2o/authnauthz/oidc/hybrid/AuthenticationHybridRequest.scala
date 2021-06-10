package com.github.j5ik2o.authnauthz.oidc.hybrid

import com.github.j5ik2o.authnauthz.oauth2.AbstractAuthorizationRequest
import com.github.j5ik2o.authnauthz.oidc._
import com.github.j5ik2o.authnauthz.{ ClientId, RedirectURI, State }

final case class AuthenticationHybridRequest(
    // OAuth2
    override val responseTypes: ResponseTypes,
    override val clientId: ClientId,
    override val redirectURI: RedirectURI,
    override val scopes: Scopes,
    override val state: Option[State],
    // OpenID Connect
    responseMode: Option[ResponseMode],
    display: Option[Display],
    prompt: Option[Prompt],
    maxAge: Option[MaxAge],
    uiLocales: Option[UILocales],
    idTokenHint: Option[IdTokenHint],
    loginHint: Option[LoginHint],
    acrValues: Option[AcrValues]
) extends AbstractAuthorizationRequest(responseTypes, clientId, redirectURI, scopes, state)
