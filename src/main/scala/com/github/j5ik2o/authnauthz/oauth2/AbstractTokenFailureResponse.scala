package com.github.j5ik2o.authnauthz.oauth2

import com.github.j5ik2o.authnauthz.base

abstract class AbstractTokenFailureResponse(
    val error: base.ErrorType,
    val errorDescription: Option[ErrorDescription],
    val errorUri: Option[ErrorUri]
) extends TokenResponse
