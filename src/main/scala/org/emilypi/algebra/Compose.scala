package org.emilypi.algebra

/**
  * Created by emilypi on 6/23/17.
  */
trait Compose[=>:[_, _]]  { self =>
  def compose[A, B, C](f: B =>: C, g: A =>: B): (A =>: C)
}


