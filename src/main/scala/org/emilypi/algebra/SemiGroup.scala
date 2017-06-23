package org.emilypi.algebra

import org.emilypi.moreschemes.instances.BinaryOp

/**
  * Created by emilypi on 6/22/17.
  */
trait SemiGroup[F[_]] {

  def <>[A]: BinaryOp[F[A]]

  def ∘[G[_]]: SemiGroup[λ[α => F[G[α]]]]

}


