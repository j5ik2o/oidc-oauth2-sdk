package com.github.j5ik2o.authnauthz.oidc

abstract class AbstractTokenFailureResponse(
    val error: ErrorType,
    val errorDescription: Option[String],
    val errorUri: Option[String]
) extends TokenResponse
