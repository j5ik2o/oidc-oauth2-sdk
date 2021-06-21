package com.github.j5ik2o.authnauthz.oauth2

import java.util.UUID

final case class AuthorizationCode(value: String)

object AuthorizationCode {

  def apply(): AuthorizationCode = {
    AuthorizationCode(UUID.randomUUID().toString)
  }
}
