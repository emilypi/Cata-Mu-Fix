package org.emilypi.algebra

/**
  * Created by emilypi on 6/23/17.
  */
package object instances {

  implicit val abelianBinaryOperation = new Commutative[Function2] {
    override def commutative[A, B, C](f: (A, B) => C): Boolean =
      f(1, 2) == f(2, 1)
  }
}
