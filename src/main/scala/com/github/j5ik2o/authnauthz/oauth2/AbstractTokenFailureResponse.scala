package com.github.j5ik2o.authnauthz.oauth2

abstract class AbstractTokenFailureResponse(
    val error: ErrorType,
    val errorDescription: Option[ErrorDescription],
    val errorUri: Option[ErrorUri]
) extends TokenResponse
