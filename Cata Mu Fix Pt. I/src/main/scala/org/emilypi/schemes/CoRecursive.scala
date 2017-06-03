package org.emilypi.schemes

import org.emilypi.cata.Functor

/**
  * Created by emilypi on 6/3/17.
  */
trait Corecursive[T[_[_]]] {
  def embed[F[_]: Functor](t: F[T[F]]): T[F]
}
