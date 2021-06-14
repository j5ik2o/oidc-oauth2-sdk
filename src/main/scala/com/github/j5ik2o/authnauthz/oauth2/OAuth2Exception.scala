package com.github.j5ik2o.authnauthz.oauth2

class OAuth2Exception(val errorType: ErrorType, cause: Option[Throwable] = None)
    extends Exception(s"errorType = $errorType", cause.orNull)
