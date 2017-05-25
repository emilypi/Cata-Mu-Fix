package com.yoppworks.scalaupnorth

/**
  * Created by emilypi on 5/25/17.
  */
package object fold {

  type ~>[F[_], G[_]] = NaturalTransformation[F, G]

  type Algebra[F[_], A] = F[A] => A

  type L[H] = Fix[ListF[H, ?]]

  type Id[+A] = A

  implicit def listf[H] = new Functor[ListF[H, ?]] {
    def fmap[A, B](f: A => B)(fa: ListF[H, A]): ListF[H, B] =
      fa match {
        case NilF => NilF
        case Cons(x, xs) => Cons(x, f(xs))
      }
  }

  def nil[H] = Fix[ListF[H, ?]](NilF)

  def cons[H] = (h: H, t: L[H]) => Fix[ListF[H, ?]](Cons(h, t))

  def cata[B, F[_] : Functor](phi: F[B] => B)(fix: Fix[F]): B =
    phi(implicitly[Functor[F]].fmap(cata[B, F](phi))(fix.unFix))

  def sumF = cata[Int, ListF[Int, ?]]{ case Cons(h, t) => h + t; case NilF => 0 } _
  def countF = cata[Int, ListF[Int, ?]]{ case Cons(h, t) => 1 + t; case NilF => 0 } _
  def appendF[H](bs: L[H]) = cata[L[H], ListF[H, ?]] { case Cons(h, t) => cons(h, t); case NilF => bs } _


}

