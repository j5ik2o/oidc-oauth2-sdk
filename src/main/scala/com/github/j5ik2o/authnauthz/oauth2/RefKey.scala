package com.github.j5ik2o.authnauthz.oauth2

import java.util.UUID

final case class RefKey(value: String)

object RefKey {
  def apply(): RefKey = RefKey(UUID.randomUUID().toString)
}
