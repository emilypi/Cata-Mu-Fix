package org.emilypi.moreschemes

/**
  * Created by emilypi on 6/3/17.
  */
trait Birecursive[A] extends Recursive[A] with Corecursive[A]
