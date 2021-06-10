package com.github.j5ik2o.authnauthz.oauth2

import com.github.j5ik2o.authnauthz.base
import enumeratum._

sealed abstract class ResponseType(override val entryName: String) extends EnumEntry

object ResponseType extends Enum[ResponseType] {
  override def values: IndexedSeq[ResponseType] = findValues

  case object Code  extends ResponseType("code")
  case object Token extends ResponseType("token")

}

final case class ResponseTypes(values: Set[ResponseType]) extends base.ResponseTypes
