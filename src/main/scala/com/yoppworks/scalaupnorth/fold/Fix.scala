package com.yoppworks.scalaupnorth.fold

/**
  * Created by emilypi on 5/18/17.
  */
final case class Fix[F[_]](unFix: F[Fix[F]])