package com.github.j5ik2o.authnauthz.oidc

import enumeratum._

sealed abstract class Scope(override val entryName: String) extends EnumEntry

object Scope extends Enum[Scope] {
  override def values: IndexedSeq[Scope] = findValues
  case object OpenId              extends Scope("openid")
  case object OfflineAccess       extends Scope("offline_access")
  case class Value(value: String) extends Scope(value)
}

final case class Scopes(values: Seq[Scope])
