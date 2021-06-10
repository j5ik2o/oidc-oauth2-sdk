package com.github.j5ik2o.authnauthz.oauth2

import com.github.j5ik2o.authnauthz.base.{ ResponseTypes, Scopes }

abstract class AbstractAuthorizationRequest(
    val responseTypes: ResponseTypes,
    val clientId: ClientId,
    val redirectURI: RedirectURI,
    val scopes: Scopes,
    val state: Option[State]
) extends AuthorizationRequest
