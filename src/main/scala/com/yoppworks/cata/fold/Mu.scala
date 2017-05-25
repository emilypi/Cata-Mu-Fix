package com.yoppworks.cata.fold

/**
  * Created by emilypi on 5/25/17.
  */
final case class Mu[F[_]](unMu: Algebra[F, ?] ~> Id)
