package org.emilypi.schemes

/**
  * Created by emilypi on 5/27/17.
  */
sealed abstract class NatF[+A]
final case class S[+A](n: A) extends NatF[A]
case object Z extends NatF[Nothing]

object NatF {
  import instances._

  implicit class natOps(n: Fix[NatF[?]]) {

    def toInt: Int = NatF.toInt(n)

    //note that + is structurally equivalent to append
    def + = cata[Fix[NatF[?]], NatF[?]] { case Z => n; case S(t) => succ(t) }

    //Hey look, we *can* multiply by 0!
    def * = cata[Fix[NatF[?]], NatF[?]] { case Z => zero; case S(t) => n + t }
  }

  def apply(n: Int): Fix[NatF[?]] =
  n match {
    case 0 => zero
    case _ => succ(apply(n - 1))
  }

  def toInt: Fix[NatF[?]] => Int =
    cata[Int, NatF[?]] { case S(n) => 1 + n; case Z => 0 }

  def zero = Fix[NatF[?]](Z)

  def one = succ(zero)

  def succ(n: Fix[NatF[?]]) = Fix[NatF[?]](S(n))

}
