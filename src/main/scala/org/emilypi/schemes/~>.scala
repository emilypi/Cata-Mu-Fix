package org.emilypi.schemes


trait ~>[F[_], G[_]] {
  def apply[A](fa: F[A]): G[A]
}
