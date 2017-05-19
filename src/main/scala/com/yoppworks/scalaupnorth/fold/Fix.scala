package com.yoppworks.scalaupnorth.fold

/**
  * Created by emilypi on 5/18/17.
  */
case class Mu[F[_]](unFix: F[Mu[F]])