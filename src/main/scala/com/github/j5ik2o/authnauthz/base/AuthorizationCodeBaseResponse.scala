package com.github.j5ik2o.authnauthz.base

import com.github.j5ik2o.authnauthz.oauth2.{ AuthorizationCode, State }

trait AuthorizationCodeBaseResponse

trait AuthorizationSuccessfulCodeBaseResponse extends AuthorizationCodeBaseResponse {
  def code: AuthorizationCode
  def state: Option[State]
}

trait AuthorizationFailureCodeBaseResponse extends AuthorizationCodeBaseResponse {
  def error: ErrorType
  def errorDescription: Option[String]
  def errorURI: Option[String]
  def state: Option[State]
}
