package com.github.j5ik2o.authnauthz.oidc

import java.time.Instant

sealed trait StringOrURI

object StringOrURI {
  final case class String(value: String) extends StringOrURI
  final case class URI(value: URI)       extends StringOrURI
}

case class IdToken(
    iss: Option[StringOrURI],
    sub: Option[StringOrURI],
    aud: Option[StringOrURI],
    exp: Option[Instant],
    iat: Option[Instant],
    authTime: Instant,
    nonce: String,
    acr: String,
    amr: String,
    azp: String
) {
  def issuer: Option[StringOrURI]     = iss
  def subject: Option[StringOrURI]    = sub
  def audience: Option[StringOrURI]   = aud
  def expirationTime: Option[Instant] = exp
  def issuedAt: Option[Instant]       = iat
}
