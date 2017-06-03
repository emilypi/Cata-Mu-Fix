package org.emilypi.schemes

import org.emilypi.cata.Functor

/**
  * Created by emilypi on 6/3/17.
  */
trait Recursive[T[_[_]]] {
  def project[F[_]: Functor](t: T[F]): F[T[F]]
}