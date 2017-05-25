package com.yoppworks.scalaupnorth.fold


trait Functor[F[_]] {
  def fmap[A, B](f: A => B)(fa: F[A]): F[B]
}