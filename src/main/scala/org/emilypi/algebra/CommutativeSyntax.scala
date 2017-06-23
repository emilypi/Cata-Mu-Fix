package org.emilypi.algebra

/**
  * Created by emilypi on 6/23/17.
  */
final class CommutativeOps[Arr[_, _, _], A, B, C] (val self: Arr[A, B, C])(implicit val F: Commutative[Arr]) {

  final def ab: Boolean = F.commutative(self)

  final def flip[A, B, C](f: (A, B) => C): (B, A) => C =
    (b: B, a: A) => f(a, b)

}

trait ToCommutativeOps  {
  implicit def ToCommutativeOps[Arr[_, _, _], A, B, C](f: Arr[A, B, C])(implicit F0: Commutative[Arr]) =
    new CommutativeOps(f)
}

trait CommutativeSyntax[Arr[_, _, _]]  {
  implicit def ToCommutativeOps[A, B, C](v: Arr[A, B, C]): CommutativeOps[Arr, A, B, C] =
    new CommutativeOps(v)(CommutativeSyntax.this.F)

  def F: Commutative[Arr]
  ////

  ////
}
