package com.github.j5ik2o.authnauthz.oidc

import com.github.j5ik2o.authnauthz.{ AccessToken, State }

import scala.concurrent.duration.Duration

case class TokenResponse(
    accessToken: AccessToken,
    tokenType: String,
    expiresIn: Duration,
    idToken: IdToken,
    scope: Scopes,
    state: Option[State]
)
