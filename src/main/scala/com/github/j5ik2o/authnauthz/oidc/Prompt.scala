package com.github.j5ik2o.authnauthz.oidc

import enumeratum._

sealed abstract class Prompt(override val entryName: String) extends EnumEntry

object Prompt extends Enum[Prompt] {
  override def values: IndexedSeq[Prompt] = findValues
  case object None          extends Prompt("none")
  case object Login         extends Prompt("login")
  case object Consent       extends Prompt("consent")
  case object SelectAccount extends Prompt("select_account")
}
