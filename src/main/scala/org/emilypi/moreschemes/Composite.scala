package org.emilypi.moreschemes

/**
  * Created by emilypi on 6/4/17.
  */
case class Composite[F[_], G[_], A](run: F[G[A]])