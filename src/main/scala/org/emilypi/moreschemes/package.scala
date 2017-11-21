package org.emilypi

import org.emilypi.schemes.{Algebra, Coalgebra}

/**
  * Created by emilypi on 6/3/17.
  */
package object moreschemes {

  type Id[A] = A

  type :+:[F[_], G[_]] = Coproduct[F, G]

  type :*:[F[_], G[_]] = Product[F, G]

  type Dialgebra[F[_], G[_], A] = F[A] => G[A]

  type GAlgebra[F[_], W[_], A] = F[W[A]] => A

  type GCoalgebra[W[_], F[_], A] = A => F[W[A]]

  // Note: Bialgebra f g a = Dialgebra[(F :+: Id), (Id :+: G), A]
  type Bialgebra[F[_], G[_], A] = Algebra[F, A] :*: Coalgebra[G, A]

  type GBialgebra[F[_[_]], G[_[_]], M[_], W[_], A] = GAlgebra[F, W, A] :*: GCoalgebra[G, M, A]


}
