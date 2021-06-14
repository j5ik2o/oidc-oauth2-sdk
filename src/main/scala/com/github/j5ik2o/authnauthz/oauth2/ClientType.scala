package com.github.j5ik2o.authnauthz.oauth2

import enumeratum._

/** クライアントタイプ。
  *
  * クライアントタイプは, 認可サーバーが定めるセキュア認証の定義とクライアントクレデンシャルの許容公開レベルに基づいて決定される. 認可サーバーは, クライアントタイプに関して憶測に頼るべきではない (SHOULD NOT).
  *
  * @param entryName
  */
sealed abstract class ClientType(override val entryName: String) extends EnumEntry

object ClientType extends Enum[ClientType] {
  override def values: IndexedSeq[ClientType] = findValues

  case object Confidential extends ClientType("confidential")
  case object Public       extends ClientType("public")
}
