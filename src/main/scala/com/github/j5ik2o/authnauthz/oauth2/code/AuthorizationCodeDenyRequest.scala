package com.github.j5ik2o.authnauthz.oauth2.code

final case class AuthorizationCodeDenyRequest(refKey: String, clientId: String, context: Map[String, AnyRef])
