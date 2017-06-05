package org.emilypi.higher

/**
  * Created by emilypi on 6/4/17.
  */
case class :*:[F[_], G[_], A](run: (F[A], G[A]))
