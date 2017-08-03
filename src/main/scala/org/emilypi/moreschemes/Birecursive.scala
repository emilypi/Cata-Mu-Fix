package org.emilypi.moreschemes

/**
  * Created by emilypi on 6/3/17.
  */
trait Birecursive[T[_[_]]] extends Corecursive[T] with Recursive[T]
