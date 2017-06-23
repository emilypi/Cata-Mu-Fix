package org.emilypi.algebra

/**
  * Created by emilypi on 6/23/17.
  */
trait Commutative[Arr[_, _, _]] {
  self =>

  def commutative[A, B, C](f: Arr[A, B, C]): Boolean

  def commutativeIsNatural: Boolean = false

  trait CommutativeLaw {
    def commutative[A, B, C](f: Arr[A, B, C]): Boolean = commutative(f)
  }

  def commutativeLaw = new CommutativeLaw {}


  def commutativeSyntax[A, B, C] = new CommutativeSyntax[Arr] { def F = Commutative.this }
}