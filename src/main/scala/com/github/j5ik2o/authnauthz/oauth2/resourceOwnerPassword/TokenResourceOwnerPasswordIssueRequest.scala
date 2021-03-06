package com.github.j5ik2o.authnauthz.oauth2.resourceOwnerPassword

import com.github.j5ik2o.authnauthz.oauth2.{ GrantType, Scopes, TokenIssueRequest }

final case class TokenResourceOwnerPasswordIssueRequest(
    grantType: GrantType,
    userName: String,
    password: String,
    scopes: Scopes
) extends TokenIssueRequest
