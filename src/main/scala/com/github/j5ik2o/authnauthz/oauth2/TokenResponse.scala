package com.github.j5ik2o.authnauthz.oauth2

import com.github.j5ik2o.authnauthz.{ AccessToken, RefreshToken }

import scala.concurrent.duration.Duration

trait TokenResponse

abstract class AbstractTokenSuccessfulResponse(
    val accessToken: AccessToken,
    val tokenType: String,
    val expiresIn: Duration,
    val scopes: Scopes
) extends TokenResponse

abstract class AbstractTokenFailureResponse(
    val error: ErrorType,
    val errorDescription: Option[String],
    val errorUri: Option[String]
) extends TokenResponse
