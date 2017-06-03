package org.emilypi.higher

import org.emilypi.schemes._

case class Nu[F[_]](unNu: Id ~> Coalgebra[?, F])

