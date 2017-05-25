package com.yoppworks.cata.fold

trait Functor[F[_]] {
  def fmap[A, B](f: A => B)(fa: F[A]): F[B]
}