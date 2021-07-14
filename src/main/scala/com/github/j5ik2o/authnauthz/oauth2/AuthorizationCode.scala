package com.github.j5ik2o.authnauthz.oauth2

import java.util.UUID

final case class AuthorizationCodeId(value: String)

final case class AuthorizationCode(id: AuthorizationCodeId)

object AuthorizationCode {

  def apply(): AuthorizationCode =
    new AuthorizationCode(AuthorizationCodeId(UUID.randomUUID().toString))

}
