package org.emilypi.higher

import org.emilypi.schemes._


final case class Mu[F[_]](unMu: Algebra[F, ?] ~> Id)
