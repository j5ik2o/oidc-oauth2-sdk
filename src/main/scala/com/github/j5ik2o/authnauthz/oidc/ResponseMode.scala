package com.github.j5ik2o.authnauthz.oidc

import enumeratum._

sealed abstract class ResponseMode(override val entryName: String) extends EnumEntry

object ResponseMode extends Enum[ResponseMode] {
  override def values: IndexedSeq[ResponseMode] = findValues

  case object Query    extends ResponseMode("query")
  case object Fragment extends ResponseMode("fragment")
  case object FromPost extends ResponseMode("form_post")
}
