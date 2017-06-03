package org.emilypi.schemes

/**
  * Created by emilypi on 6/3/17.
  */

sealed trait Free[F[_], A]
final case class Pure[F[_], A](value: A) extends Free[F, A]
final case class Wrap[F[_], A](unWrap: F[Free[F, A]]) extends Free[F, A]
