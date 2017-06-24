package org.emilypi.algebra

/**
  * Created by emilypi on 6/23/17.
  */
trait Compose[F[_]] { self =>
  def compose[G[_], A](f: F[B, C], g: ): (A =>: C)
}


