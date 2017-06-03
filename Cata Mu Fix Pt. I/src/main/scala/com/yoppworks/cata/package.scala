package com.yoppworks



package object cata {

  import instances._, implicits._, Fix._

  type Algebra[F[_], A] = F[A] => A

  type CoAlgebra[B, F[_]] = B => F[B]

  type Id[+A] = A

  def cata[B, F[_] : Functor](φ: Algebra[F, B])(fix: Fix[F]): B =
    φ ∘ implicitly[Functor[F]].fmap(cata(φ)) ∘ fix.unFix

  def ana[F[_] : Functor, B](ψ: CoAlgebra[B, F])(b: B): Fix[F] =
    Fix ∘ (implicitly[Functor[F]].fmap(ana(ψ)) ∘ ψ(b))

  def hylo[F[_] : Functor, A, B](φ: Algebra[F, B])(ψ: CoAlgebra[A, F])(a: A): B =
    cata(φ) ∘ ana(ψ) ∘ a

  def meta[A, B, F[_] : Functor](ψ: CoAlgebra[A, F])(φ: Algebra[F, A])(fix: Fix[F]): Fix[F] =
    ana(ψ) ∘ cata(φ) ∘ fix

  def sumF: Fix[ListF[Int, ?]] => Int =
    cata[Int, ListF[Int, ?]]{ case Cons(h, t) => h + t; case NilF => 0 } _

  def countF: Fix[ListF[Int, ?]] => Int =
    cata[Int, ListF[Int, ?]]{ case Cons(h, t) => 1 + t; case NilF => 0 } _

  def genList[H]: Int => Fix[ListF[Int, ?]] =
    ana[ListF[Int, ?], Int] { case 0 => NilF; case n => Cons(n, n - 1) } _

  def collapseList: Fix[ListF[Int, ?]] => Int =
    cata[Int, ListF[Int, ?]] { case NilF => 1; case Cons(h, t) => h * t } _

  def factorial: Int => Int =
    hylo[ListF[Int, ?], Int, Int]
      { case NilF => 1; case Cons(h, t) => h * t }
      { case 0 => NilF; case n => Cons(n, n - 1) }


  def _factorial: Int => Int = collapseList ∘ genList




}
