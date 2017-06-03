package org.emilypi

package object cata {
  import implicits._

  type Algebra[F[_], A] = F[A] => A

  type Coalgebra[B, F[_]] = B => F[B]

  type Id[+A] = A

  def cata[B, F[_]](φ: Algebra[F, B])(fix: Fix[F])(implicit F: Functor[F]): B =
    φ ∘ F.fmap(cata(φ)) _ ∘ fix.unFix

  def ana[F[_], B](ψ: Coalgebra[B, F])(b: B)(implicit F: Functor[F]): Fix[F] =
    Fix ∘ (F.fmap(ana(ψ)) _ ∘ ψ(b))

  def hylo[F[_] : Functor, A, B](φ: Algebra[F, B])(ψ: Coalgebra[A, F])(a: A): B =
    cata(φ) _ ∘ ana(ψ) _ ∘ a

  def meta[A, B, F[_] : Functor](ψ: Coalgebra[A, F])(φ: Algebra[F, A])(fix: Fix[F]): Fix[F] =
    ana(ψ) _ ∘ cata(φ) _ ∘ fix


}
