package org.emilypi.schemes

final case class Fix[F[_]](unFix: F[Fix[F]])

object Fix {

  def ∘[F[_]](unfix: F[Fix[F]]): Fix[F] = Fix(unfix)

}

