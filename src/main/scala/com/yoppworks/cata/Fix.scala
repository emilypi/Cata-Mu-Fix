package com.yoppworks.cata

final case class Fix[F[_]](unFix: F[Fix[F]])
