package org.emilypi.higher

/**
  * Created by emilypi on 6/4/17.
  */
trait Profunctor[P[_, _]] {
  def dimap[A, B, C, D](fab: P[A, B])(f: C => A)(g: B => D): P[C, D]
}
