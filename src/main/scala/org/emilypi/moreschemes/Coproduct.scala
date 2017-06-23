package org.emilypi.moreschemes

/**
  * Created by emilypi on 6/4/17.
  */
trait Coproduct[F[_], G[_]] {
  def run[A]: Either[F[A], G[A]]
}

