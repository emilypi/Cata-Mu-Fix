package org.emilypi.moreschemes

/**
  * Created by emilypi on 6/4/17.
  */
trait :*:[F[_], G[_]] {
  type λ[A] = (F[A], G[A])
}
