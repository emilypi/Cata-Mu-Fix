package org.emilypi.higher

import org.emilypi.schemes.Functor

/**
  * Created by emilypi on 6/3/17.
  */
trait Recursive[T[_[_]]] {
  def project[F[_]: Functor](t: T[F]): F[T[F]]
}