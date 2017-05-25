package com.yoppworks.cata.fold

/**
  * Created by emilypi on 5/25/17.
  */
trait NaturalTransformation[F[_], G[_]] {
  def apply[A](fa: F[A]): G[A]
}
