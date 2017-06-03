package com.yoppworks.cata

/**
  * Created by emilypi on 6/2/17.
  */
package object examples {
  import instances._, implicits._

  def sumF: Fix[ListF[Int, ?]] => Int =
    cata[Int, ListF[Int, ?]]{ case Cons(h, t) => h + t; case NilF => 0 } _

  def countF: Fix[ListF[Int, ?]] => Int =
    cata[Int, ListF[Int, ?]]{ case Cons(h, t) => 1 + t; case NilF => 0 } _

  def genList[H]: Int => Fix[ListF[Int, ?]] =
    ana[ListF[Int, ?], Int] { case 0 => NilF; case n => Cons(n, n - 1) } _

  def collapseList: Fix[ListF[Int, ?]] => Int =
    cata[Int, ListF[Int, ?]] { case NilF => 1; case Cons(h, t) => h * t } _

  def factorial: Int => Int =
    hylo[ListF[Int, ?], Int, Int]
      { case NilF => 1; case Cons(h, t) => h * t }
      { case 0 => NilF; case n => Cons(n, n - 1) }

  def _factorial: Int => Int = collapseList ∘ genList

}
