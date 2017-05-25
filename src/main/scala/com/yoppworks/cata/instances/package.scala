package com.yoppworks.cata

import com.yoppworks.cata._
/**
  * Created by emilypi on 5/25/17.
  */
package object instances {

  implicit def listf[H] = new Functor[ListF[H, ?]] {
    def fmap[A, B](f: A => B)(fa: ListF[H, A]): ListF[H, B] =
      fa match {
        case NilF => NilF
        case Cons(x, xs) => Cons(x, f(xs))
      }
  }

  implicit def list[H] = new Functor[List] {
    def fmap[A, B](f: (A) => B)(fa: List[A]): List[B] =
      fa match {
        case x +: xs => f(x) +: fmap(f)(xs)
        case Nil => Nil
      }
  }

}
