package com.github.j5ik2o.authnauthz.oidc

import com.github.j5ik2o.authnauthz.AccessToken

import scala.concurrent.duration.Duration

abstract class AbstractTokenSuccessfulResponse(
    val accessToken: AccessToken,
    val tokenType: String,
    val expiresIn: Duration,
    val idToken: IdToken,
    val scopes: Scopes
) extends TokenResponse
