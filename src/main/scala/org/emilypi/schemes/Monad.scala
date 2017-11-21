package org.emilypi.schemes

trait Monad[M[_]] extends Functor[M] with Applicative[M] {

  def bind[A, B](k: A => M[B]): M[B]
}

object Monad {

  implicit class monadOps[M[_]](ma: Monad[M]) {

    def >>=[A, B](k: A => M[B]): M[B] =
      ma.bind(k)
  }
}
