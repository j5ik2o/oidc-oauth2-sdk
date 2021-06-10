package com.github.j5ik2o.authnauthz.oidc

import com.github.j5ik2o.authnauthz.{ ClientId, RedirectURI, State }

abstract class AbstractAuthorizationRequest(
    val responseTypes: ResponseTypes,
    val clientId: ClientId,
    val redirectURI: RedirectURI,
    val scopes: Scopes,
    val state: Option[State]
)
