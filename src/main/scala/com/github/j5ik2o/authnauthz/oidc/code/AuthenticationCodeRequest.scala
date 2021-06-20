package com.github.j5ik2o.authnauthz.oidc.code

import com.github.j5ik2o.authnauthz.{ oauth2, oidc }

final case class AuthenticationCodeRequest(
    // OAuth2
    responseTypes: oidc.ResponseTypes,
    clientId: oauth2.ClientId,
    redirectURI: oauth2.RedirectUri,
    scopes: oidc.Scopes,
    state: Option[oauth2.State],
    // OpenID Connect
    responseMode: Option[oidc.ResponseMode],
    display: Option[oidc.Display],
    prompt: Option[oidc.Prompt],
    maxAge: Option[oidc.MaxAge],
    uiLocales: Option[oidc.UILocales],
    idTokenHint: Option[oidc.IdTokenHint],
    loginHint: Option[oidc.LoginHint],
    acrValues: Option[oidc.AcrValues]
)
