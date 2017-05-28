package com.yoppworks


package object cata {
  import instances._

  type Algebra[F[_], A] = F[A] => A

  type Id[+A] = A

  def cata[B, F[_] : Functor](φ: Algebra[F, B])(fix: Fix[F]): B =
    φ(implicitly[Functor[F]].fmap(cata[B, F](φ))(fix.unFix))


  /** Examples of ListF operations */
  def sumF = cata[Int, ListF[Int, ?]]{ case Cons(h, t) => h + t; case NilF => 0 } _

  def countF = cata[Int, ListF[Int, ?]]{ case Cons(h, t) => 1 + t; case NilF => 0 } _

}
