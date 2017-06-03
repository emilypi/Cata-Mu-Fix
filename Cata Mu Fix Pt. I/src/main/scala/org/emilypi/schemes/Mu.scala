package org.emilypi.schemes

import org.emilypi.cata._


final case class Mu[F[_]](unMu: Algebra[F, ?] ~> Id)
