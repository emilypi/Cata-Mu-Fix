 package org.emilypi.schemes

/**
  * Created by emilypi on 5/27/17.
  */
sealed abstract class TreeF[+A, +T]
final case class BranchF[+A, +T](a: A, l: T, r: T) extends TreeF[A, T]
final case object TipF extends TreeF[Nothing, Nothing]

object TreeF {

  def tip[A] = Fix[TreeF[A, ?]](TipF)

  def branch[A, T](a: A, l: Fix[TreeF[A, ?]], r: Fix[TreeF[A, ?]]) =
    Fix[TreeF[A, ?]](BranchF(a, l, r))

}
