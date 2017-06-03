package org.emilypi.cata

/**
  * Created by emilypi on 5/27/17.
  */
sealed abstract class NatF[+A]
final case class S[+A](n: A) extends NatF[A]
case object Z extends NatF[Nothing]

object NatF {
  import instances._

  implicit class natOps(n: Fix[NatF[?]]) {

    def toInt: Int =
      cata[Int, NatF[?]] { case S(n) => 1 + n; case Z => 0 }(n)
  }

  def apply(n: Int): Fix[NatF[?]] =
  n match {
    case 0 => zero
    case _ => succ(apply(n - 1))
  }


  def zero = Fix[NatF[?]](Z)

  def succ(n: Fix[NatF[?]]) = Fix[NatF[?]](S(n))

}
