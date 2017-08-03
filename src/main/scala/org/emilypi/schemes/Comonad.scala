package org.emilypi.schemes

trait Comonad[W[_]] extends Functor[W] {
  import implicits._

  def counit[A]: W[A] => A //admits an F-algebra

  def =<<[A, B](k: W[A] => B)(wa: W[A]): W[B]

  def cojoin[A](wa: W[A]): W[W[A]] = ???

  def liftW[A, B](f: A => B): W[A] => W[B] = =<< (f ∘ counit[A]) _
}
