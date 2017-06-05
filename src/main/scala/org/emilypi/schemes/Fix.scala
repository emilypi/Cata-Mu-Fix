package org.emilypi.schemes

final case class Fix[F[_]](unFix: F[Fix[F]])

object Fix {

  def ∘[F[_], B](unfix: B => F[Fix[F]]): B => Fix[F] = (b: B) => Fix(unfix(b))

}

