package com.yoppworks.scalaupnorth.fold

/**
  * Created by emilypi on 5/18/17.
  */
object GeneralizedFold {
  import Instances._

  def nil[H] = Mu[ListF[H, ?]](NilF)

  def cons[H] = (h: H, t: Mu[ListF[H, ?]]) => Mu[ListF[H, ?]](Cons(h, t))

  def cata[B, F[_] : Functor](phi: F[B] => B)(fix: Mu[F]): B =
    phi(implicitly[Functor[F]].fmap(cata[B, F](phi))(fix.unFix))

  def sumListF = cata[Int, ListF[Int, ?]]{ case Cons(h, t) => 1 + t; case NilF => 0 } _
  def countListF = cata[Int, ListF[Int, ?]]{ case Cons(h, t) => 1 + t; case NilF => 0 } _


}


