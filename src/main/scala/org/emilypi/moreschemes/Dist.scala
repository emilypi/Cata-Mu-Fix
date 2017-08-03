package org.emilypi.moreschemes

trait Dist[F[_], W[_]] {
  type λ[A] = F[W[A]] => W[F[A]]
}
