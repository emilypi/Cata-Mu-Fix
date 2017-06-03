package org.emilypi.schemes

/**
  * Created by emilypi on 6/2/17.
  */
package object implicits {

  implicit class fOps[A, B, E](f: A => B) {
    //compose functions
    def ∘(g: E => A): E => B = (a: E) => f(g(a))

    def ∘(a: A): B = f(a)
  }

}
