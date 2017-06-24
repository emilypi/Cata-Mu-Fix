package org.emilypi.algebra.syntax

import org.emilypi.algebra.Commutative

/**
  * Created by emilypi on 6/23/17.
  */
final class CommutativeOps[F[_, _, _], A, B, C] (val self: F[A, B, C])(implicit val F: Commutative[F]) {

  final def commutative: Boolean = F.commutative(self)

}

trait ToCommutativeOps  {
  implicit def ToCommutativeOps[F[_, _, _], A, B, C](f: F[A, B, C])(implicit F0: Commutative[F]) =
    new CommutativeOps(f)
}

trait CommutativeSyntax[F[_, _, _]]  {
  implicit def ToCommutativeOps[A, B, C](v: F[A, B, C]): CommutativeOps[F, A, B, C] =
    new CommutativeOps(v)(CommutativeSyntax.this.F)

  def F: Commutative[F]
  ////

  ////
}
