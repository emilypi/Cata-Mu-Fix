package org.emilypi

package object schemes {
  import implicits._

  type Algebra[F[_], A] = F[A] => A

  type Coalgebra[B, F[_]] = B => F[B]

  def cata[F[_], B](φ: Algebra[F, B])(implicit F: Functor[F]): Fix[F] => B =
    φ ∘ F.liftF(cata(φ)) ∘ _.unFix

  def ana[A, F[_]](ψ: Coalgebra[A, F])(implicit F: Functor[F]): A => Fix[F] =
    Fix ∘ F.liftF(ana(ψ)) ∘ ψ ∘ _

  def hylo[F[_] : Functor, A, B](φ: Algebra[F, B])(ψ: Coalgebra[A, F]): A => B =
    cata(φ) ∘ ana(ψ)

  def meta[A, F[_] : Functor](ψ: Coalgebra[A, F])(φ: Algebra[F, A]): Fix[F] => Fix[F] =
    ana(ψ) ∘ cata(φ)


}
