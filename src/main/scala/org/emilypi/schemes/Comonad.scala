package org.emilypi.schemes

trait Comonad[W[_]] extends Functor[W] {
  import implicits._

  def counit[A]: W[A] => A //admits an F-algebra

  def cobind[A, B](k: W[A] => B): W[B]

  def cojoin[A]: W[W[A]] = cobind[A, W[A]](id)

  def liftW[A, B](f: A => B): W[B] = cobind(f ∘ counit[A])
}

object Comonad {

  implicit class comonadOps[W[_]](wa: Comonad[W]) {

    def =<<[A, B](k: W[A] => B): W[B] =
      wa.cobind(k)
  }
}
