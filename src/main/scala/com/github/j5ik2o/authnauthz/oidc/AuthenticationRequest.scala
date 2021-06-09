package com.github.j5ik2o.authnauthz.oidc

import com.github.j5ik2o.authnauthz._

final case class AuthenticationRequest(
    responseTypes: ResponseTypes,
    clientId: ClientId,
    redirectURI: RedirectURI,
    scopes: Scopes,
    state: Option[State],
    responseMode: Option[ResponseMode],
    display: Option[Display],
    prompt: Option[Prompt],
    maxAge: Option[MaxAge],
    uiLocales: Option[UILocales],
    idTokenHint: Option[IdTokenHint],
    loginHint: Option[LoginHint],
    acrValues: Option[AcrValues]
)
