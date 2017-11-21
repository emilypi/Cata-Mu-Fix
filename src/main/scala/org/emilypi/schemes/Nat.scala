package org.emilypi.schemes

sealed trait Nat
object Nat {

  implicit class natOps(n: Nat) {
    def toInt: Int =
      foldn[Int](_ + 1)(0)(n)
  }

  def apply(i: Int): Nat =
    if (i == 0) Z
    else S(apply(i - 1))

  def foldn[A](f: A => A)(z: A)(n: Nat): A =
    n match {
      case S(n) => f(foldn(f)(z)(n))
      case Z    => z
    }
}

final case class S(n: Nat) extends Nat
case object Z extends Nat
