package org.emilypi.moreschemes

/**
  * Created by emilypi on 6/24/17.
  */
final case class Cofree[F[_], A](head: A, tail: F[Cofree[F, A]])