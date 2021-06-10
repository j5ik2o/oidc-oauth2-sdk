package com.github.j5ik2o.authnauthz.oidc.hybrid

import com.github.j5ik2o.authnauthz.oidc.IdToken
import com.github.j5ik2o.authnauthz.{ AccessToken, AuthorizationCode }

sealed trait AuthenticationHybridResponse

final case class AuthenticationHybridSuccessfulResponse(
    accessToken: Option[AccessToken],
    idToken: Option[IdToken],
    code: AuthorizationCode
)
