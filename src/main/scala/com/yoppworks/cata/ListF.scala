package com.yoppworks.cata


sealed trait ListF[+H, +T]
final case class Cons[H, +T](head: H, tail: T) extends ListF[H, T]
final case object NilF extends ListF[Nothing, Nothing]

object ListF {
  import com.yoppworks.cata.instances._

  implicit class lfOps[H](lf: Fix[ListF[H, ?]]) {

    def @:(h: H): Fix[ListF[H, ?]] = cons(h, lf)

    def appendF(bs: Fix[ListF[H, ?]]) = cata[Fix[ListF[H, ?]], ListF[H, ?]]
      { case Cons(h, t) => cons(h, t); case NilF => bs }(lf)

    def toList: List[H] = cata[List[H], ListF[H, ?]] { case Cons(h, t) => h :: t; case NilF => Nil }(lf)

  }

  def apply[H, ?](hs: H*): Fix[ListF[H, ?]] =
    hs.foldLeft(Fix[ListF[H, ?]](NilF))((f: Fix[ListF[H, ?]], h: H) => cons[H](h, f))

  def nil[H] = Fix[ListF[H, ?]](NilF)

  def cons[H] = (h: H, t: Fix[ListF[H, ?]]) => Fix[ListF[H, ?]](Cons(h, t))

}