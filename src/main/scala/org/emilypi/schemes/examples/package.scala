package org.emilypi.schemes

/**
  * Created by emilypi on 6/2/17.
  */
package object examples {
  import implicits._
  import instances._

  /** ListF examples */
  def sumF: Fix[ListF[Int, ?]] => Int =
    cata[ListF[Int, ?], Int] { case Cons(h, t) => h + t; case NilF => 0 }

  def countF: Fix[ListF[Int, ?]] => Int =
    cata[ListF[Int, ?], Int] { case Cons(h, t) => 1 + t; case NilF => 0 }

  def genList: Int => Fix[ListF[Int, ?]] =
    ana[Int, ListF[Int, ?]] { case 0 => NilF; case n => Cons(n, n - 1) }

  def collapseList: Fix[ListF[Int, ?]] => Int =
    cata[ListF[Int, ?], Int] { case NilF => 1; case Cons(h, t) => h * t }

  //explicitly hylomorphic fac
  def factorial: Int => Int =
    hylo[ListF[Int, ?], Int, Int]
      { case NilF => 1; case Cons(h, t) => h * t }
      { case 0 => NilF; case n => Cons(n, n - 1) }

  //implicitly hylomorphic fac
  def _factorial: Int => Int = collapseList ∘ genList

  /** TreeF examples - more included in TreeF object */
  def inOrder[N]: Fix[TreeF[N, ?]] => Unit =
    cata[TreeF[N, ?], Unit] { case BranchF(a, l, r) => println(a.toString); case TipF => println("Tip") }

  def genFibTree[N]: Int => Fix[TreeF[Int, ?]] =
    ana[Int, TreeF[Int, ?]] { case 0 => TipF; case 1 => BranchF(1, 0, 0); case n if n > 1 => BranchF(n,  n - 1, n - 2)}

  def cataFibTree: Fix[TreeF[Int, ?]] => Int =
    cata[TreeF[Int, ?], Int] { case TipF => 0; case BranchF(_, 0, 0) => 1; case BranchF(_, l, r) => l + r}

  //explicitly hylomorphic fac
  def fibonacci: Int => Int =
    hylo[TreeF[Int, ?], Int, Int]
      { case TipF => 0; case BranchF(_, 0, 0) => 1; case BranchF(_, l, r) => l + r }
      { case 0 => TipF; case 1 => BranchF(1, 0, 0); case n => BranchF(n, n - 1, n - 2) }

  //implicitly hylomorphic fac
  def _fibonacci: Int => Int = cataFibTree ∘ genFibTree


}
