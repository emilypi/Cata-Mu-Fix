package org.emilypi.schemes


sealed abstract class ListF[+H, +T]
final case class @:[H, +T](head: H, tail: T) extends ListF[H, T]
case object NilF extends ListF[Nothing, Nothing]

object ListF {
  import instances._

  implicit class lfFixOps[H](lf: Fix[ListF[H, ?]]) {

    def @:(h: H): Fix[ListF[H, ?]] = cons(h, lf)

    def @::(bs: Fix[ListF[H, ?]]): Fix[ListF[H, ?]] => Fix[ListF[H, ?]] =
      cata[ListF[H, ?], Fix[ListF[H, ?]]] { case h @: t => cons(h, t); case NilF => bs }

    def toList: List[H] = ListF.toList(lf)

  }

  //foldRight is implemented in terms of foldLeft for Traversables. It's safe.
  def apply[H, ?](hs: H*): Fix[ListF[H, ?]] =
    hs.foldRight(nil[H])(cons[H])

  def nil[H]: Fix[ListF[H, ?]] = Fix[ListF[H, ?]](NilF)

  def cons[H]: (H, Fix[ListF[H, ?]]) => Fix[ListF[H, ?]] =
    (h: H, t: Fix[ListF[H, ?]]) => Fix[ListF[H, ?]](@:(h, t))

  def toList[H]: Fix[ListF[H, ?]] => List[H] =
    cata[ListF[H, ?], List[H]] { case h @: t => h :: t; case NilF => Nil }
}