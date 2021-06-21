package com.github.j5ik2o.authnauthz.oidc

import com.github.j5ik2o.authnauthz.oauth2
import enumeratum._

sealed abstract class Scope(override val entryName: String) extends EnumEntry

object Scope extends Enum[Scope] {
  override def values: IndexedSeq[Scope] = findValues
  case object OpenId              extends Scope("openid")
  case object OfflineAccess       extends Scope("offline_access")
  case class Value(value: String) extends Scope(value)
}

final case class Scopes(values: Set[Scope]) {

  def toOAuth2: oauth2.Scopes = {
    oauth2.Scopes(values.map(s => oauth2.Scope(s.entryName)))
  }

}
