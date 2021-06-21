package com.github.j5ik2o.authnauthz

import com.github.j5ik2o.authnauthz.oauth2.Client

trait RequestHandler[SELF, Result] {
  type Output[_]
  def execute(self: SELF, client: Client): Output[Result]
}

object RequestHandler {

  implicit class RequestHandlerOps[A, Result](val self: A) {

    def execute(client: Client)(implicit ev: RequestHandler[A, Result]): ev.Output[Result] =
      ev.execute(self, client)
  }

}

trait ClientAuthenticator[SELF, REQ, RES] {
  type Output[_]
  def execute(self: SELF, req: REQ): Output[RES]
}
