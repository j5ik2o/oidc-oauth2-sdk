package com.github.j5ik2o.authnauthz.oidc.hybrid

import com.github.j5ik2o.authnauthz.oauth2.{ ClientId, RedirectURI, State }
import com.github.j5ik2o.authnauthz.oidc._

final case class AuthenticationHybridRequest(
    // OAuth2
    responseTypes: ResponseTypes,
    clientId: ClientId,
    redirectURI: RedirectURI,
    scopes: Scopes,
    state: Option[State],
    // OpenID Connect
    responseMode: Option[ResponseMode],
    display: Option[Display],
    prompt: Option[Prompt],
    maxAge: Option[MaxAge],
    uiLocales: Option[UILocales],
    idTokenHint: Option[IdTokenHint],
    loginHint: Option[LoginHint],
    acrValues: Option[AcrValues]
)
