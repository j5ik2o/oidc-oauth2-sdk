package com.github.j5ik2o.authnauthz.oauth2

import com.github.j5ik2o.authnauthz.AccessToken

import scala.concurrent.duration.Duration

abstract class AbstractTokenSuccessfulResponse(
    val accessToken: AccessToken,
    val tokenType: String,
    val expiresIn: Duration,
    val scopes: Scopes
) extends TokenResponse
