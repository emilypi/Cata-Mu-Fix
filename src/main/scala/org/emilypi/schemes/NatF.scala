package org.emilypi.schemes


sealed abstract class NatF[+A]
final case class SS[+A](n: A) extends NatF[A]
case object ZZ extends NatF[Nothing]

object NatF {
  import instances._

  implicit class natOps(n: Fix[NatF[?]]) {

    def toInt: Fix[NatF[?]] => Int =
      cata[NatF[?], Int] { case SS(n) => 1 + n; case ZZ => 0 }

    //note that + is structurally equivalent to append
    def + : Fix[NatF[?]] => Fix[NatF[?]] =
      cata[NatF[?], Fix[NatF[?]]] { case ZZ => n; case SS(t) => succ(t) }

    //Hey look, we *can* multiply by 0... but is it really 0?
    def * : Fix[NatF[?]] => Fix[NatF[?]] =
      cata[NatF[?], Fix[NatF[?]]] { case ZZ => zero; case SS(t) => n + t }
  }

  def apply(n: Int): Fix[NatF[?]] =
  n match {
    case 0 => zero
    case _ => succ(apply(n - 1))
  }

  def zero = Fix[NatF[?]](ZZ)

  def succ(n: Fix[NatF[?]]) = Fix[NatF[?]](SS(n))

}
