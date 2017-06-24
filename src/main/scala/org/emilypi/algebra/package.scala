package org.emilypi.algebra


/**
  * Created by emilypi on 6/23/17.
  */

package object algebra {
  import instances._

  def comm[A, Function2[_, _, _] : Commutative](f: (A, A) => A): (A, A) => A = f
}