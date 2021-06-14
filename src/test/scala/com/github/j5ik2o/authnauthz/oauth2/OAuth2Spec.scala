package com.github.j5ik2o.authnauthz.oauth2

import org.scalatest.freespec.AnyFreeSpec

class OAuth2Spec extends AnyFreeSpec {

  "2. クライアント登録" - {

    /** OAuth プロトコルフローを開始する前に, クライアントは認可サーバーに登録する.
      * クライアントが認可サーバーに登録する方法は本仕様での範囲外であるが, 通常エンドユーザーとの対話を伴うHTML登録フォームを持つ.
      *
      * クライアントの登録は, クライアントと認可サーバー間の直接的なやりとりを必須としない.
      * 認可サーバーでサポートされている場合, 必要なクライアントのプロパティー (例えばリダイレクトURIやクライアントタイプ) を取得し信頼を確立する他の方法を用いて登録を行うことができる.
      * 例えば, クライアント自身もしくはサードパーティーが発行したアサーションを使用したり, 認可サーバーが信頼できるチャネルを使用してクライアントのディスカバリーを行うことで, 登録を行うことができる.
      *
      * クライアントを登録する場合, クライアント開発者は以下を満たすものとする (SHALL).
      *
      * Section 2.1 で説明されているようなクライアントタイプを指定し,
      * Section 3.1.2 で説明されているようなリダイレクトURIを提供し,
      * 認可サーバーが要求するその他の情報 (例えばアプリケーション名, Webサイト, 説明, ロゴイメージ, 利用規則など) を提供する.
      */

    "2.1.  クライアントタイプ" in {

      /** 認可サーバーと安全に認証する能力 (クライアントクレデンシャルの機密性を維持できる能力など) に基づいて, OAuthは二つのクライアントタイプを定義している.
        *
        * - コンフィデンシャル (confidential)
        *   クレデンシャルの機密性を維持することができるクライアント (例えば, クライアントクレデンシャルへのアクセスが制限されたセキュアサーバー上に実装されたクライアント), または他の手段を使用したセキュアなクライアント認証ができるクライアント.
        * - パブリック (public)
        *   (例えば, インストールされたネイティブアプリケーションやブラウザベースのWebアプリケーションなど, リソースオーナーのデバイス上で実行されるクライアントのように) クライアントクレデンシャルの機密性を維持することができず, かつ他の手段を使用したセキュアなクライアント認証もできないクライアント.
        *   クライアントタイプは, 認可サーバーが定めるセキュア認証の定義とクライアントクレデンシャルの許容公開レベルに基づいて決定される. 認可サーバーは, クライアントタイプに関して憶測に頼るべきではない (SHOULD NOT).
        *
        * クライアントによっては, 分散された複数のコンポーネントによって実装され, それぞれのコンポーネントが異なるクライアントタイプおよびセキュリティ特性を持つ場合もある. (例: コンフィデンシャルなサーバーベースコンポーネントとパブリックなブラウザベースのコンポーネントからなるクライアントなど) 認可サーバーがこのようなクライアントをサポートしない, もしくはクライアント登録に関して何らかのガイダンスを提供していない場合, クライアントはそれぞれのコンポーネントを別のクライアントとして登録すべきである (SHOULD).
        *
        * 本仕様は以下のようなクライアントプロファイルを考慮して設計されている,
        *
        * Webアプリケーション (web application)
        *   Webアプリケーションは, Webサーバー上で実行されているコンフィデンシャルクライアントである. リソースオーナーは, リソースオーナーのデバイス上のユーザーエージェントにレンダリングされたHTMLユーザーインターフェイスを通してクライアントにアクセスする. クライアントに発行されたアクセストークンと同様にクライアントクレデンシャルはWebサーバー上に保存され, リソースオーナーによって公開されたりアクセス可能な状態にならない.
        * ユーザーエージェントベースアプリケーション (user-agent-based application)
        *   ユーザーエージェントベースアプリケーションは, クライアントコードがWebサーバーからダウンロードされリソースオーナーのデバイス上のユーザーエージェント (例えばWebブラウザ) 内で実行されるパブリッククライアントである. プロトコルのデータとクレデンシャルはリソースオーナーに簡単にアクセス (かつ多くの場合は閲覧) できる. このようなアプリケーションはユーザーエージェント内にあるので, 認可を要求する時ユーザーエージェントの能力をシームレスに使用することができる.
        * ネイティブアプリケーション (native application)
        *   ネイティブアプリケーションは, リソースオーナーのデバイス上にインストールされ実行されるパブリッククライアントである. リソースオーナーはプロトコルのデータとクレデンシャルにアクセス可能である. アプリケーションに含まれるいかなるクライアント認証用のクレデンシャルも, 抽出可能であると想定される. 一方, アクセストークンやリフレッシュトークンといった動的に発行されたクレデンシャルは許容できるレベルの保護が得られる. 少なくとも, これらのクレデンシャルはアプリケーションと対話できる悪意のあるサーバーから保護されている. プラットフォームによっては, これらのクレデンシャルは同じデバイス上に存在する他のアプリケーションからも保護されているであろう.
        */

    }
    "2.2.  クライアント識別子" in {

      /** 認可サーバーは登録済みのクライアントにクライアント識別子 (クライアントが提供した登録情報を表すユニーク文字列) を発行する.
        * クライアント識別子はシークレットと異なりリソースオーナーに露出されるため, その情報のみでクライアント認証を行ってはならない (MUST NOT). クライアント識別子は認可サーバーごとにユニークである.
        *
        * クライアント識別子の文字列長は本仕様の定めるところではない. クライアントは識別子のサイズに関して憶測を持つべきではない.
        * 認可サーバーは, 発行するいかなる識別子に関しても, そのサイズに関する情報を提供すべきである (SHOULD).
        */
      assert(ClientId() != ClientId())
    }
    "2.3.  クライアント認証" - {

      /** クライアントタイプがコンフィデンシャルである場合, クライアントと認可サーバーは, 認可サーバーのセキュリティ要求を満たすクライアント認証方式を確立する.
        * 認可サーバーは自身のセキュリティ要求さえ満たせば, どのような方式のクライアント認証に対応してもよい (MAY).
        *
        * コンフィデンシャルクライアントには, 通常は認可サーバーでの認証に使われるクライアントクレデンシャルのセットが発行 (もしくは確立) される. 例) パスワード, 公開鍵／秘密鍵のペア
        *
        * 認可サーバーはパブリッククライアントとクライアント認証によって信頼確立してもよい (MAY). しかし, 認可サーバーはクライアントを識別する目的で, パブリッククライアントを信頼してはならない (MUST NOT).
        *
        * クライアントは1回のリクエストにおいて二つ以上の認証方式を利用してはならない (MUST NOT).
        */

      "2.3.1.  クライアントパスワード" in {

        /** クライアントパスワードを保持しているクライアントは, 認可サーバー上での認証に[RFC2617]で定義されているHTTP Basic認証スキームを使用してもよい (MAY).
          * この場合, クライアント識別子はAppendix Bの定めるapplication/x-www-form-urlencoded形式にエンコードされ, エンコードされた値がユーザーネームとして用いられる.
          * クライアントパスワードも同様にエンコードされ, パスワードとして利用される. 認可サーバーは, クライアントパスワードを発行されたクライアントの認証の為にHTTP Basic認証スキームをサポートしなければならない (MUST).
          *
          * 例 (改行は表示上の都合による):
          *
          * Authorization: Basic czZCaGRSa3F0Mzo3RmpmcDBaQnIxS3REUmJuZlZkbUl3
          *
          * HTTP Basic認証スキームの代わりに, 認可サーバーは以下のパラメーターを用いてリクエストボディーにクライアントクレデンシャルを含めてもよい (MAY).
          *
          * client_id
          *   必須 (REQUIRED). Section 2.2 に示されるクライアント登録時に発行されたクライアント識別子.
          * client_secret
          *   必須 (REQUIRED). クライアントのシークレット. 空の場合は省略してもよい (MAY).
          *
          * 2つのパラメーターを使ってクライアントクレデンシャルをリクエストボディーに含めることは推奨されていない (NOT RECOMMENDED).
          * この方法はHTTP Basic認証スキーム (もしくは他のパスワードベースのHTTP認証スキーム) が直接利用できないクライアントに限定すべきある (SHOULD).
          * これらのパラメーターはリクエストボディー経由でのみ送信可能であり, リクエストURI経由で送信してはならない (MUST NOT).
          *
          * 例：ボディパラメーターを使ってアクセストークンを更新 (Section 6) する場合 (改行は表示上の都合による)
          *
          *  POST /token HTTP/1.1
          *  Host: server.example.com
          *  Content-Type: application/x-www-form-urlencoded
          *
          *  grant_type=refresh_token&refresh_token=tGzv3JOkF0XG5Qx2TlKWIA
          *  &client_id=s6BhdRkqt3&client_secret=7Fjfp0ZBr1KtDRbnfVdmIw
          *
          * パスワード認証を行う場合, 認可サーバーはSection 1.6にある通りTLSの利用を必須としなければならない (MUST).
          *
          * クライアント認証方式にパスワードが含まれるので, 認可サーバーはクライアント認証を行うすべてのエンドポイントでブルートフォースアタック対策を行わなくてはならない (MUST).
          */
      }

      "2.3.2.  その他の認証方式" in {

        /** 認可サーバーは, 自身のセキュリティ要件に適合するいかなるHTTP認証スキームをサポートしてよい (MAY). 他の認証方式を利用する際には, 認可サーバーはクライアント識別子 (つまり登録されたクライアント) と認証スキームのマッピングを明確にしなければならない (MUST).
          */
      }

    }
    "2.4.  未登録クライアント" in {

      /** 本仕様は, 未登録のクライアントの利用を排除するものではない. しなしながら, そのようなクライアントの利用は本仕様のスコープ外であり, さらなるセキュリティー面の分析と相互運用性への影響度評価が必要である.
        */
    }
  }

  "3.  プロトコルエンドポイント" - {

    /** 認可プロセスは, 認可サーバー上の2つのエンドポイント (HTTP リソース) およびクライアント上の1つのエンドポイントを利用する. 認可サーバー上のエンドポイントは以下の通り:
      *
      * 認可エンドポイント - ユーザーエージェント経由でリソースオーナーから認可を得るためにクライアントから利用される.
      * トークンエンドポイント - 認可グラントとアクセストークンを交換するために, クライアントから利用される. 通常はクライアント認証を行う.
      * クライアント上のエンドポイントは以下の通り:
      *
      * リダイレクトエンドポイント - リソースオーナーのユーザーエージェント経由で認可クレデンシャルを含むレスポンスをクライアント側へ返すために, 認可サーバーによって利用される.
      * すべてのグラントタイプが, これらすべてのエンドポイントを使用するわけではない. 拡張されたグラントタイプは必要に応じて追加のエンドポイントを定義してもよい (MAY).
      */
    "3.1.  認可エンドポイント" - {

      /** 認可エンドポイントは, リソースオーナーとのインタラクションを通じて認可を得るために使用される. 認可サーバーは, まずリソースオーナーのアイデンティティを確認しなければならない (MUST).
        * 認可サーバーが用いるリソースオーナーの認証方法 (ユーザー名とパスワードによるログイン, セッションクッキー) については, 本仕様の定めるところではない.
        *
        * クライアントが認可エンドポイントURLを取得する方法は本仕様の定めるところではないが, そのURLは一般的にサービスドキュメントで提供される.
        *
        * エンドポイントURIは application/x-www-form-urlencoded (Appendix B) フォーマットのクエリーコンポーネント ([RFC3986] セクション3.4) を含んでもよい (MAY).
        * クエリーパラメーターを追加する際, ここで指定されたクエリーコンポーネントは維持すること (MUST). エンドポイントURIはフラグメントコンポーネントを含んではいけない (MUST NOT).
        *
        * 認可エンドポイントへのリクエストはユーザー認証と (HTTPレスポンス内に) 平文のクレデンシャルの転送がされるため, 認可エンドポイントにリクエストを送信する際, 認可サーバーはTLS (Section 1.6) を利用されなければならない (MUST).
        *
        * 認可サーバーは認可エンドポイントでHTTP GET メソッド ([RFC2616]) をサポートしなければならず (MUST), 同様に POST メソッドをサポートしてもよい (MAY).
        *
        * パラメーターの値がない場合は, パラメーター自体が省略されているものとして扱わなければならない (MUST).
        * 認可サーバーは識別できないリクエストパラメーターを無視すること (MUST). リクエストおよびレスポンスパラメーターは重複してはならない (MUST NOT).
        */
      "3.1.1.  レスポンスタイプ" in {

        /** 認可エンドポイントは認可コードグラントタイプとインプリシットタイプのフローで使用される. クライアントは以下に示すパラメーターを利用して, 希望するグラントタイプを認可サーバーに通知する.
          *
          * response_type
          *   必須 (REQUIRED). レスポンスタイプの値は Section 4.1.1 で後述する認可コードをリクエストするための code あるいは,
          *   Section 4.2.1 で後述するアクセストークン (インプリシットグラント) をリクエストする token あるいは,
          *   Section 8.4 で後述する登録されている拡張された値のいずれかでなければならない (MUST).
          *
          * 拡張レスポンスタイプに空白文字 (%x20) 区切りのリスト値が含まれていてもよい (MAY).
          * なお値の順序は問題としない (例：レスポンスタイプ a b と b a は同じである). このような復号レスポンスタイプの意味は各々の仕様にて定義される.
          *
          * 認可リクエストで response_type がない場合, もしくは未知のレスポンスタイプであった場合, 認可サーバーは Section 4.1.2.1 で述べるエラーレスポンスを返さなくてはならない (MUST).
          */
        assert(ResponseTypes.parse(None) == Left(new OAuth2Exception(ErrorType.InvalidRequest)))
        assert(ResponseTypes.parse(Some("aaaa")) == Left(new OAuth2Exception(ErrorType.UnsupportedResponseType)))
        assert(ResponseTypes.parse(Some("code")) == Right(ResponseTypes(ResponseType.Code)))
        assert(ResponseTypes.parse(Some("token")) == Right(ResponseTypes(ResponseType.Token)))
        assert(ResponseTypes.parse(Some("code token")) == Right(ResponseTypes(ResponseType.Code, ResponseType.Token)))
        assert(ResponseTypes.parse(Some("token code")) == Right(ResponseTypes(ResponseType.Code, ResponseType.Token)))

      }
      "3.1.2.  リダイレクトエンドポイント" in {

        /** リソースオーナーとのやりとりが完了した後, 認可サーバーはリソースオーナーのユーザーエージェントをクライアントへ誘導する.
          * 認可サーバーは, ユーザーエージェントを事前登録済もしくは認可リクエスト時に指定されたクライアントのリダイレクトエンドポイントにリダイレクトさせる.
          *
          * リダイレクトエンドポイントのURIは [RFC3986] のセクション4.3で定義されている絶対URIでなければいけない (MUST). エンドポイントURIは application/x-www-form-urlencoded (Appendix B) フォーマットのクエリーコンポーネント ([RFC3986] セクション3.4) を含んでもよい (MAY).
          * クエリーパラメーターを追加する際, ここで指定されたクエリーコンポーネントは維持すること (MUST). エンドポイントURIはフラグメントコンポーネントを含んではいけない (MUST NOT).
          */
      }
    }

  }

}
