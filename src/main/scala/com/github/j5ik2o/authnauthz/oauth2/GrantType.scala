package com.github.j5ik2o.authnauthz.oauth2

import enumeratum._

sealed abstract class GrantType(override val entryName: String) extends EnumEntry

object GrantType extends Enum[GrantType] {
  override def values: IndexedSeq[GrantType] = findValues

  case object AuthorizationCode                             extends GrantType("authorization_code")
  case object RefreshToken                                  extends GrantType("refresh_token")
  case object Password                                      extends GrantType("password")
  case object ClientCredentials                             extends GrantType("client_credentials")
  case class ExtensionGrant(override val entryName: String) extends GrantType(entryName)
}
