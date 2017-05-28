package com.yoppworks.cata

/**
  * Created by emilypi on 5/25/17.
  */
trait ~>[F[_], G[_]] {
  def apply[A](fa: F[A]): G[A]
}
