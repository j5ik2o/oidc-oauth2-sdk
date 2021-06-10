package com.github.j5ik2o.authnauthz.oidc.code

import com.github.j5ik2o.authnauthz.{ base, oauth2, oidc }

final case class AuthenticationCodeRequest(
    // OAuth2
    override val responseTypes: oidc.ResponseTypes,
    override val clientId: oauth2.ClientId,
    override val redirectURI: oauth2.RedirectURI,
    override val scopes: oidc.Scopes,
    override val state: Option[oauth2.State],
    // OpenID Connect
    responseMode: Option[oidc.ResponseMode],
    display: Option[oidc.Display],
    prompt: Option[oidc.Prompt],
    maxAge: Option[oidc.MaxAge],
    uiLocales: Option[oidc.UILocales],
    idTokenHint: Option[oidc.IdTokenHint],
    loginHint: Option[oidc.LoginHint],
    acrValues: Option[oidc.AcrValues]
) extends oauth2.AbstractAuthorizationRequest(responseTypes, clientId, redirectURI, scopes, state)
    with base.AuthorizationCodeBaseRequest
    with oidc.AuthenticationRequest
