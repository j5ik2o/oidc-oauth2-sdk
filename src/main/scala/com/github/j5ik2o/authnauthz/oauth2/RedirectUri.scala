package com.github.j5ik2o.authnauthz.oauth2

import com.github.j5ik2o.uri.Uri

import java.text.ParseException

final case class RedirectUri(uri: Uri) {
  def isFull: Boolean    = uri.query.nonEmpty
  def isPartial: Boolean = uri.path.isEmpty || uri.query.isEmpty

  def compareAndMatch(redirectUri: RedirectUri, forceFull: Boolean): Boolean = redirectUri match {
    case that: RedirectUri if forceFull || isFull =>
      val b = uri.asString == that.uri.asString
      println(s"Full: this = $this, ${uri.asString}, that = $that, ${that.uri.asString}, b = $b")
      (that canEqual this) && b
    case that: RedirectUri if isPartial =>
      val b = uri.scheme == that.uri.scheme &&
        uri.authority == that.uri.authority &&
        uri.path == that.uri.path
      println(s"Partial: this = $this, ${Seq(uri.scheme.asString, uri.authority.asString, uri.path.asString)
        .mkString(",")} that = $that, ${Seq(that.uri.scheme.asString, that.uri.authority.asString, that.uri.path.asString)
        .mkString(",")} b = $b")
      (that canEqual this) && b
    case _ => false
  }

}

object RedirectUri {

  def apply(uri: Uri): RedirectUri = new RedirectUri(uri)

  def parseWithException(value: String): RedirectUri = {
    parse(value).fold(throw _, identity)
  }

  def parse(value: String): Either[ParseException, RedirectUri] = {
    Uri.parse(value).flatMap { uri =>
      if (!uri.isAbsolute) {
        Left(new ParseException(s"The redirect uri is not absolute. uri = $uri, ${uri.fragment}", 0))
      } else if (uri.query.exists(_.getParam("code").nonEmpty)) {
        Left(new ParseException("The query params in the redirect uri contains 'code'.", 0))
      } else if (uri.query.exists(_.getParam("state").nonEmpty)) {
        Left(new ParseException("The query params in the redirect uri contains 'state'.", 0))
      } else {
        Right(RedirectUri(uri))
      }
    }
  }

}

final case class RedirectUris(values: Vector[RedirectUri]) {
  def isEmpty: Boolean              = values.isEmpty
  def nonEmpty: Boolean             = !isEmpty
  def isSingle: Boolean             = values.size == 1
  def isMultiple: Boolean           = !isSingle
  def toVector: Vector[RedirectUri] = values
  def hasPartial: Boolean           = values.exists(_.isPartial)

  def contains(redirectUri: RedirectUri, forceFull: Boolean): Boolean =
    values.exists(value => redirectUri.compareAndMatch(value, forceFull))
}
