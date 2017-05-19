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

  implicit def seqFunctor[A] = new Functor[Seq] {
    override def fmap[A, B](f: (A) => B)(fa: Seq[A]): Seq[B] =
      fa match {
        case x +: xs => f(x) +: fmap(f)(xs)
        case _ => Seq()
      }
  }

}
