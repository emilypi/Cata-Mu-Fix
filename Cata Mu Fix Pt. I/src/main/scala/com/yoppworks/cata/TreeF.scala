package com.yoppworks.cata

/**
  * Created by emilypi on 5/27/17.
  */
sealed abstract class TreeF[+A, +T]
final case class BranchF[+A, +T](a: A, l: T, r: T) extends TreeF[A, T]
final case object TipF extends TreeF[Nothing, Nothing]

object TreeF {
  import instances._

  implicit class treeOps[A](t: Fix[TreeF[A, ?]]) {

    def count: Int = cata[Int, TreeF[A, ?]] { case BranchF(a, l, r) => 1 + l + r; case TipF => 0 }(t)

    def depth: Int = cata[Int, TreeF[A, ?]] { case BranchF(a, l, r) => 1 + Math.max(l, r); case TipF => 0 }(t)

    def inOrder: Unit =
      cata[Unit, TreeF[A, ?]] { case BranchF(a, l, r) => println(a.toString); case TipF => println("Tip") }(t)

  }

  def tip[A] = Fix[TreeF[A, ?]](TipF)

  def branch[A, T](a: A, l: Fix[TreeF[A, ?]], r: Fix[TreeF[A, ?]]) =
    Fix[TreeF[A, ?]](BranchF(a, l, r))

}
