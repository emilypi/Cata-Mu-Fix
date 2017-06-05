package org.emilypi.schemes

final case class Fix[F[_]](unFix: F[Fix[F]])


