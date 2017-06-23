package org.emilypi

import org.emilypi.algebra.{Commutative, SemiGroup}
import org.emilypi.moreschemes.instances.BinaryOp

/**
  * Created by emilypi on 6/3/17.
  */
package object moreschemes {
  import schemes._
  import implicits._, instances._

  type Id[+A] = A


}
