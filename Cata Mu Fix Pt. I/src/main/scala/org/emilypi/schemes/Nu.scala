package org.emilypi.schemes

import org.emilypi.cata._

case class Nu[F[_]](unNu: Id ~> Coalgebra[?, F])

