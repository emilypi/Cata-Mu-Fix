package org.emilypi.moreschemes

/**
  * Created by emilypi on 6/4/17.
  */
trait Bifunctor[F[_, _]] {
  def bimap[A, B, C, D](fab: F[A, B])(f: A => C, g: B => D): F[C, D]
}
