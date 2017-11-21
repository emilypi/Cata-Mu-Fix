package org.emilypi.schemes

import org.emilypi.schemes.NatF.{succ, zero}

/**
  * Created by emilypi on 6/2/17.
  */
package object examples {
  import implicits._
  import instances._

  /** ListF examples */
  def sumF: Fix[ListF[Int, ?]] => Int =
    cata[ListF[Int, ?], Int] { case h @: t => h + t; case NilF => 0 }

  def countF: Fix[ListF[Int, ?]] => Int =
    cata[ListF[Int, ?], Int] { case h @: t => 1 + t; case NilF => 0 }

  def genList: Int => Fix[ListF[Int, ?]] =
    ana[Int, ListF[Int, ?]] { case 0 => NilF; case n => @:(n, (n - 1)) }

  def collapseList: Fix[ListF[Int, ?]] => Int =
    cata[ListF[Int, ?], Int] { case NilF => 1; case h @: t => h * t }

  //explicitly hylomorphic fac
  def factorial: Int => Int =
    hylo[ListF[Int, ?], Int, Int] { case NilF => 1; case h @: t => h * t } {
      case 0 => NilF; case n => @:(n, n - 1)
    }

  //implicitly hylomorphic fac
  def _factorial: Int => Int = collapseList ∘ genList

  /** TreeF examples - more included in TreeF object */
  def count[A]: Fix[TreeF[A, ?]] => Int =
    cata[TreeF[A, ?], Int] {
      case BranchF(a, l, r) => 1 + l + r; case TipF => 0
    }

  def depth[A]: Fix[TreeF[A, ?]] => Int =
    cata[TreeF[A, ?], Int] {
      case BranchF(a, l, r) => 1 + Math.max(l, r); case TipF => 0
    }

  def inOrder[N]: Fix[TreeF[N, ?]] => Unit =
    cata[TreeF[N, ?], Unit] {
      case BranchF(a, l, r) => println(a.toString); case TipF => println("Tip")
    }

  def genFibTree[N]: Int => Fix[TreeF[Int, ?]] =
    ana[Int, TreeF[Int, ?]] {
      case 0          => TipF; case 1 => BranchF(1, 0, 0);
      case n if n > 1 => BranchF(n, n - 1, n - 2)
    }

  def cataFibTree: Fix[TreeF[Int, ?]] => Int =
    cata[TreeF[Int, ?], Int] {
      case TipF => 0; case BranchF(_, 0, 0) => 1; case BranchF(_, l, r) => l + r
    }

  //explicitly hylomorphic fib
  def fibonacci: Int => Int =
    hylo[TreeF[Int, ?], Int, Int] {
      case TipF => 0; case BranchF(_, 0, 0) => 1; case BranchF(_, l, r) => l + r
    } {
      case 0 => TipF; case 1 => BranchF(1, 0, 0);
      case n => BranchF(n, n - 1, n - 2)
    }

  //implicitly hylomorphic fib
  def _fibonacci: Int => Int = cataFibTree ∘ genFibTree

  //Prepromorphism example - using a natural transformation that
  val doubleListF = new (ListF[Int, ?] ~> ListF[(Int, Int), ?]) {
    override def apply[A](fa: ListF[Int, A]): ListF[(Int, Int), A] =
      fa match {
        case h @: t => @:((h, 2 * h), t)
        case NilF   => NilF
      }
  }

  def doubleListFSum: Fix[ListF[Int, ?]] => (Int, Int) =
    prepro[ListF[Int, ?], ListF[(Int, Int), ?], (Int, Int)](doubleListF) {
      case h @: t => (h._1 + t._1, h._2 + t._2); case NilF => (0, 0)
    }

}
