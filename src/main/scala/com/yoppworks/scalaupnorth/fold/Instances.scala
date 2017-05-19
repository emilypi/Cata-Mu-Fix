package com.yoppworks.scalaupnorth.fold

/**
  * Created by emilypi on 5/18/17.
  */
object Instances {

  implicit def listFFunctor[H] = new Functor[ListF[H, ?]] {
    def fmap[A, B](f: A => B)(fa: ListF[H, A]): ListF[H, B] =
      fa match {
        case NilF => NilF
        case Cons(x, xs) => Cons(x, f(xs))
      }
  }
}
