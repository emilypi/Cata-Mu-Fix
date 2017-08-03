package org.emilypi.schemes

trait Monad[M[_]] extends Functor[M] with Applicative[M] {

  def >>=[A, B](ma: M[A])(k: A => M[B]): M[B]
}
