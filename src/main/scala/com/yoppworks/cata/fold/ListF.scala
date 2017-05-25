package com.yoppworks.cata.fold

/**
  * Created by emilypi on 5/18/17.
  */
sealed trait ListF[+H, +T]
final case class Cons[H, +T](head: H, tail: T) extends ListF[H, T]
final case object NilF extends ListF[Nothing, Nothing]
