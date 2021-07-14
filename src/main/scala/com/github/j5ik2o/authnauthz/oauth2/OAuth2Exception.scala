package com.github.j5ik2o.authnauthz.oauth2

final case class OAuth2Exception(errorType: ErrorType, cause: Option[Throwable] = None)
    extends Exception(s"errorType = $errorType", cause.orNull)
