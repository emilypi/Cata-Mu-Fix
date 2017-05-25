package com.yoppworks.cata.fold

final case class Fix[F[_]](unFix: F[Fix[F]])

object Fix {

  def embedT[F[_] : Functor](f: F[Fix[F]]): Fix[F] = Fix[F](f)

  def projectT[F[_] : Functor](f: Fix[F]): F[Fix[F]] = f unFix

}