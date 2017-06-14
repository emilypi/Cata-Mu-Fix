package org.emilypi

package object schemes {
  import implicits._

  type Algebra[F[_], A] = F[A] => A

  type Coalgebra[B, F[_]] = B => F[B]

  type GAlgebra[W[_], F[_], A] = A => F[W[A]]

  type GCoalgebra[W[_], F[_], A] = F[W[A]] => A

  def cata[F[_], B](φ: Algebra[F, B])(implicit F: Functor[F]): Fix[F] => B =
    φ ∘ F.liftF(cata(φ)) ∘ _.unFix

  def ana[A, F[_]](ψ: Coalgebra[A, F])(implicit F: Functor[F]): A => Fix[F] =
    Fix ∘ F.liftF(ana(ψ)) ∘ ψ ∘ _

  def hylo[F[_] : Functor, A, B](φ: Algebra[F, B])(ψ: Coalgebra[A, F]): A => B =
    cata(φ) ∘ ana(ψ)

  def meta[A, F[_] : Functor](ψ: Coalgebra[A, F])(φ: Algebra[F, A]): Fix[F] => Fix[F] =
    ana(ψ) ∘ cata(φ)

  def prepro[F[_], A](α: F ~> F)(φ: Algebra[F, A])(implicit F: Functor[F]): Fix[F] => A =
    (fix: Fix[F]) => φ ∘ F.liftF(prepro(α)(φ)) ∘ α[Fix[F]](fix.unFix)

}
