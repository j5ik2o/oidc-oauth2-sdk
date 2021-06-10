package com.github.j5ik2o.authnauthz.oauth2

import com.github.j5ik2o.authnauthz.base

final case class Scope(value: String)
final case class Scopes(values: Seq[Scope]) extends base.Scopes
