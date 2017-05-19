package com.yoppworks.scalaupnorth.fold

/**
  * Created by emilypi on 5/18/17.
  */
trait Functor[F[_]] {
  def fmap[A, B](f: A => B)(fa: F[A]): F[B]
}