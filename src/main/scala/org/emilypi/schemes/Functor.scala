package org.emilypi.schemes

/**
  * Created by emilypi on 6/3/17.
  */
trait Functor[F[_]] {
  def fmap[A, B](f: A => B)(fa: F[A]): F[B]
}
