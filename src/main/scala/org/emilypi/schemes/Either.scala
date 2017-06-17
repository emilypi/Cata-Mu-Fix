package org.emilypi.schemes

/**
  * Created by emilypi on 6/16/17.
  */
trait Either[+A, +B]
final case class -\/[+A](a: A) extends Either[A, Nothing]
final case class \/-[+B](b: B) extends Either[Nothing, B]
