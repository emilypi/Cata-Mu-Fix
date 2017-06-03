package org.emilypi.schemes

/**
  * Created by emilypi on 5/27/17.
  */
sealed abstract class TreeF[+A, +T]
final case class BranchF[+A, +T](a: A, l: T, r: T) extends TreeF[A, T]
final case object TipF extends TreeF[Nothing, Nothing]

object TreeF {
  import instances._

  implicit class treeOps[A](t: Fix[TreeF[A, ?]]) {

    def count = TreeF.count(t)

    def depth = TreeF.depth(t)

  }

  def count[A]: Fix[TreeF[A, ?]] => Int =
    cata[Int, TreeF[A, ?]] { case BranchF(a, l, r) => 1 + l + r; case TipF => 0 }

  def depth[A]: Fix[TreeF[A, ?]] => Int =
    cata[Int, TreeF[A, ?]] { case BranchF(a, l, r) => 1 + Math.max(l, r); case TipF => 0 }

  def tip[A] = Fix[TreeF[A, ?]](TipF)

  def branch[A, T](a: A, l: Fix[TreeF[A, ?]], r: Fix[TreeF[A, ?]]) =
    Fix[TreeF[A, ?]](BranchF(a, l, r))

}
