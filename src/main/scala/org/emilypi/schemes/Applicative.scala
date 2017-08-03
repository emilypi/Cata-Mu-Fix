package org.emilypi.schemes

trait Applicative[F[_]] extends Functor[F] {

  def unit[A](a: A): F[A]

  def <*>[A, B](fa: F[A => B]): F[A] => F[B]
}
