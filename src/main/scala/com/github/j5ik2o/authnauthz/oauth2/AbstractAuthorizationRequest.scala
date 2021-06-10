package com.github.j5ik2o.authnauthz.oauth2

import com.github.j5ik2o.authnauthz._

abstract class AbstractAuthorizationRequest(
    val responseTypes: com.github.j5ik2o.authnauthz.ResponseTypes,
    val clientId: ClientId,
    val redirectURI: RedirectURI,
    val scopes: com.github.j5ik2o.authnauthz.Scopes,
    val state: Option[State]
) extends AuthorizationRequest
