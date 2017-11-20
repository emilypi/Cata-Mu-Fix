package org.emilypi

/**
  * Created by emilypi on 6/3/17.
  */
package object moreschemes {

  type Id[A] = A

  type :+:[F[_], G[_]] = Coproduct[F, G]

  type :*:[F[_], G[_]] = Product[F, G]

}
