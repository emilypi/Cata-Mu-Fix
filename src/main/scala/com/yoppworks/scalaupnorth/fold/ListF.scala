package com.yoppworks.scalaupnorth.fold


/**
  * Created by emilypi on 5/18/17.
  */
sealed trait ListF[+H, +T]
final case class Cons[H, +T](head: H, tail: T) extends ListF[H, T]
final case object NilF extends ListF[Nothing, Nothing]

object ListF {

  def nil[H] = Mu[ListF[H, ?]](NilF)

  def cons[H] = (h: H, t: Mu[ListF[H, ?]]) => Mu[ListF[H, ?]](Cons(h, t))


}