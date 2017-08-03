package org.emilypi

import org.emilypi.moreschemes.Dist

package object schemes {
  import implicits._

  type \/[A, B] = Either[A, B]

  type Algebra[F[_], A] = F[A] => A

  type Coalgebra[B, F[_]] = B => F[B]

  type GAlgebra[F[_], W[_], A] = F[W[A]] => A

  type GCoalgebra[W[_], F[_], A] = A => F[W[A]]

  def id[A]: A => A = a => a

  def cata[F[_], B](φ: Algebra[F, B])(implicit F: Functor[F]): Fix[F] => B =
    φ ∘ F.liftF(cata(φ)) ∘ _.unFix

  def ana[A, F[_]](ψ: Coalgebra[A, F])(implicit F: Functor[F]): A => Fix[F] =
    Fix ∘ F.liftF(ana(ψ)) ∘ ψ

  def hylo[F[_] : Functor, A, B](φ: Algebra[F, B])(ψ: Coalgebra[A, F]): A => B =
    cata(φ) ∘ ana(ψ)

  def meta[A, F[_] : Functor](ψ: Coalgebra[A, F])(φ: Algebra[F, A]): Fix[F] => Fix[F] =
    ana(ψ) ∘ cata(φ)

  def prepro[F[_]: Functor, G[_]: Functor, A](α: F ~> G)(φ: Algebra[G, A]): Fix[F] => A =
    cata[F, A] { φ ∘ α(_) }

  def postpro[A, F[_]: Functor](α: F ~> F)(ψ: Coalgebra[A, F]): A => Fix[F] =
    ana[A, F] { a => α(ψ(a)) }

  def gcata[F[_], W[_], A](k: Dist[F, W])(φ: GAlgebra[F, W, A])
                          (implicit F: Functor[F],  W: Comonad[W]): Fix[F] => A = ???








}
