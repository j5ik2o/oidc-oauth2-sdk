package com.github.j5ik2o.authnauthz.oauth2

import enumeratum._

sealed abstract class BehaviorType(override val entryName: String) extends EnumEntry

object BehaviorType extends Enum[BehaviorType] {
  override def values: IndexedSeq[BehaviorType] = findValues
  case object BadRequest          extends BehaviorType("bad_request")
  case object InternalServerError extends BehaviorType("internal_server_error")
  case object Interaction         extends BehaviorType("interaction")
  case object Location            extends BehaviorType("location")
}
