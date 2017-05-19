package com.yoppworks.scalaupnorth.free

import com.yoppworks.scalaupnorth.fold.{Functor, Mu}

import scala.annotation.tailrec
import scala.io.Source

/**
  * Created by emilypi on 5/19/17.
  */
case class Free[A, F[_]: Functor](resume: Either[A, F[Free[A, F]]])

case class CoFree[A, F[_]: Functor](head: A, tail: F[CoFree[A, F]])

