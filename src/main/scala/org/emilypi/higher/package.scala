package org.emilypi

/**
  * Created by emilypi on 6/3/17.
  */
package object higher {
  import schemes._
  import implicits._, instances._

  type Id[+A] = A

}
