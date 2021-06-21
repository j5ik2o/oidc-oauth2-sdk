package com.github.j5ik2o.authnauthz.oauth2

final case class Scope(value: String)
final case class Scopes(values: Set[Scope])

object Scopes {
  val empty: Scopes = Scopes(Set.empty)
}
