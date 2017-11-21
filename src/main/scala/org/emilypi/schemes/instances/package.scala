package org.emilypi.schemes

/**
  * Created by emilypi on 5/25/17.
  */
package object instances {

  def map[A, B](as: List[A])(f: A => B): List[B] =
    as match {
      case x :: xs => f(x) :: map(xs)(f)
      case Nil     => Nil
    }

  def flatMap[A, B](as: List[A])(f: A => List[B]): List[B] =
    as match {
      case x :: xs => f(x) ::: flatMap(xs)(f)
      case Nil     => Nil
    }

  def filter[A, B](as: List[A])(p: A => Boolean): List[A] =
    as match {
      case x :: xs =>
        if (p(x)) x :: filter(xs)(p)
        else filter(xs)(p)
      case Nil => Nil
    }

  implicit def natF = new Functor[NatF] {
    override def fmap[A, B](f: (A) => B)(fa: NatF[A]): NatF[B] =
      fa match {
        case SS(a) => SS(f(a))
        case ZZ    => ZZ
      }
  }

  implicit def treeF[N] = new Functor[TreeF[N, ?]] {
    override def fmap[A, B](f: (A) => B)(fa: TreeF[N, A]): TreeF[N, B] =
      fa match {
        case BranchF(a, l, r) => BranchF(a, f(l), f(r))
        case TipF             => TipF
      }
  }

  implicit def tree = new Functor[Tree] {
    override def fmap[A, B](f: (A) => B)(fa: Tree[A]): Tree[B] =
      fa match {
        case Branch(a, l, r) => Branch(f(a), fmap(f)(l), fmap(f)(r))
        case Tip             => Tip
      }

  }

  implicit def listf[H] = new Functor[ListF[H, ?]] {
    def fmap[A, B](f: A => B)(fa: ListF[H, A]): ListF[H, B] =
      fa match {
        case NilF    => NilF
        case x @: xs => @:(x, f(xs))
      }
  }

  implicit def list = new Functor[List] {
    def fmap[A, B](f: (A) => B)(fa: List[A]): List[B] =
      fa match {
        case x +: xs => f(x) +: fmap(f)(xs)
        case Nil     => Nil
      }
  }

  implicit def option = new Functor[Option] {
    override def fmap[A, B](f: (A) => B)(fa: Option[A]): Option[B] =
      fa match { case Some(v) => Some(f(v)); case None => None }
  }

  implicit def function[R] = new Functor[R => ?] {
    override def fmap[A, B](f: (A) => B)(fa: (R) => A): (R) => B =
      (r: R) => f(fa(r))
  }

}
