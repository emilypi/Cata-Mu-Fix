package org.emilypi.algebra

import syntax._


/**
  * NOTE: TRY COMMUTATORS
  */
trait Commutative[F[_, _, _]] {
  self =>

  def commutative[A, B, C](f: F[A, B, C]): Boolean

  def commutativeIsNatural: Boolean = false

  trait CommutativeLaw {
    def commutative[A, B, C](f: F[A, B, C]): Boolean = self.commutative(f)

    def commutativeIsNatural: Boolean = self.commutativeIsNatural
  }

  def commutativeLaw = new CommutativeLaw {}

  def commutativeSyntax[A, B, C] = new CommutativeSyntax[F] {
    def F = Commutative.this
  }
}