package com.github.j5ik2o.authnauthz.oauth2

import java.util.UUID

/** クライアントID
  *
  * 2.2.  クライアント識別子
  *
  * 認可サーバーは登録済みのクライアントにクライアント識別子 (クライアントが提供した登録情報を表すユニーク文字列) を発行する.
  * クライアント識別子はシークレットと異なりリソースオーナーに露出されるため, その情報のみでクライアント認証を行ってはならない (MUST NOT).
  * クライアント識別子は認可サーバーごとにユニークである.
  *
  * クライアント識別子の文字列長は本仕様の定めるところではない. クライアントは識別子のサイズに関して憶測を持つべきではない.
  * 認可サーバーは, 発行するいかなる識別子に関しても, そのサイズに関する情報を提供すべきである (SHOULD).
  *
  * @param value ID値
  */
final case class ClientId(value: String, length: Int)

object ClientId {

  def apply(): ClientId = {
    val value = UUID.randomUUID().toString
    new ClientId(value, value.length)
  }
}
