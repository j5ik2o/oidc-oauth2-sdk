package com.github.j5ik2o.authnauthz.oauth2

final case class Scope(value: String)
final case class Scopes(values: Seq[Scope])
