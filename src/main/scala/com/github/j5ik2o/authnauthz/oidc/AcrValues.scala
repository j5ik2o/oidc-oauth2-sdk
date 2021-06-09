package com.github.j5ik2o.authnauthz.oidc

final case class AcrValue(value: String)
final case class AcrValues(values: Vector[AcrValue])
