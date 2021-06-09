package com.github.j5ik2o.authnauthz.oauth2

import com.github.j5ik2o.authnauthz._

abstract class AbstractAuthorizationRequest(
    val responseTypes: ResponseTypes,
    val clientId: ClientId,
    val redirectURI: RedirectURI,
    val scopes: Scopes,
    val state: State
) extends AuthorizationRequest
