package org.emilypi.moreschemes

/**
  * GDialgebra
  */
trait ~>>[F[_[_]], G[_[_]], M[_], W[_]] {

  def apply[A](fwa: F[W[A]]): G[M[A]]
}
