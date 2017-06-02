package com.yoppworks



package object cata {
  import instances._

  type Algebra[F[_], A] = F[A] => A

  type CoAlgebra[B, F[_]] = B => F[B]

  type Id[+A] = A

  type Nat = Mu[Option]

  implicit class fOps[A, B, E](f: A => B) {
   def ∘(g: E => A): E => B = (a: E) => f(g(a))
  }

  def cata[B, F[_] : Functor](φ: Algebra[F, B])(fix: Fix[F]): B =
    φ(implicitly[Functor[F]].fmap(cata[B, F](φ))(fix.unFix))


  def ana[F[_]: Functor, B](ψ: CoAlgebra[B, F])(b: B): Fix[F] =
    Fix(implicitly[Functor[F]].fmap(ana[F, B](ψ))(ψ(b)))


  def hylo[F[_]: Functor, A, B](φ: Algebra[F, B])(ψ: CoAlgebra[A, F]): A => B =
    cata[B, F](φ) _  ∘  ana[F, A](ψ) _

  def _hylo[F[_]: Functor, A, B](φ: Algebra[F, B])(ψ: CoAlgebra[A, F]): A => B =
    (a: A) => φ(implicitly[Functor[F]].fmap(_hylo[F, A, B](φ)(ψ))(ψ(a)))



  /** Examples of ListF operations */
  def sumF = cata[Int, ListF[Int, ?]]{ case Cons(h, t) => h + t; case NilF => 0 } _

  def countF = cata[Int, ListF[Int, ?]]{ case Cons(h, t) => 1 + t; case NilF => 0 } _

}
