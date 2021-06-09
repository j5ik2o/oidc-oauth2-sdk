package com.github.j5ik2o.authnauthz.oidc

import enumeratum._

sealed abstract class Display(override val entryName: String) extends EnumEntry

object Display extends Enum[Display] {
  override def values: IndexedSeq[Display] = findValues
  case object Page  extends Display("page")
  case object Popup extends Display("popup")
  case object Touch extends Display("touch")
  case object Wap   extends Display("wap")
}
