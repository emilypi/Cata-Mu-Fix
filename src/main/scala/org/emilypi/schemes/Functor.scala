package org.emilypi.schemes

import org.emilypi.moreschemes.Composite

/**
  * Created by emilypi on 6/3/17.
  */
trait Functor[F[_]] {

  def fmap[A, B](f: A => B)(fa: F[A]): F[B]

  def liftF[A, B](f: A => B): F[A] => F[B] = fmap(f) _


}

