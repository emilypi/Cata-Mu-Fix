package org.emilypi.schemes

/**
  * Created by emilypi on 5/28/17.
  */
sealed abstract class Tree[+A]
final case class Branch[+A](a: A, l: Tree[A], r: Tree[A]) extends Tree[A]
case object Tip extends Tree[Nothing]

object Tree {

  def fold[A, B](f: A => B => B => B)(z: B)(t: Tree[A]): B =
    t match {
      case Branch(a, l, r) => f(a)(fold(f)(z)(l))(fold(f)(z)(r))
      case Tip             => z
    }
}
