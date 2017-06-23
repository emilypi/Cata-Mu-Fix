package org.emilypi

/**
  * Created by emilypi on 6/23/17.
  */

package object algebra {


  def flip[A, B, C](f: (A, B) => C): (B, A) => C =
    (b: B, a: A) => f(a, b)

  implicit val abelian_+ = new Commutative[Function2] {

    override def commutative[A, B, C](a: (A, B) => C): Boolean =
      ((t: (A, B)) => a(t._1, t._2)) == ((u: (B, A)) => flip(a)(u._1, u._2))
  }

  def comm[A](f: (A, A) => A)(implicit ev: Commutative[Function2]): (A, A) => A = {
    ev.commutativeLaw.commutative(f)
    f
  }
}
