package com.yoppworks.scalaupnorth.algebra

/**
  * Created by emilypi on 5/10/17.
  */

trait Algebra[+A] {

  def underlying[T >: A]: Set[T]
  def op[A](a: A): A
}
