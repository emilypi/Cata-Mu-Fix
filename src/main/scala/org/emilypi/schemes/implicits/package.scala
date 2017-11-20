package org.emilypi.schemes

/**
  * Created by emilypi on 6/2/17.
  */
package object implicits {

  implicit class fOps[A, B, E](f: A => B) {
    //compose functions
    def ∘(g: E => A): E => B = (e: E) => f(g(e))

    // application
    def ∘(a: A): B = f(a)
  }
}
