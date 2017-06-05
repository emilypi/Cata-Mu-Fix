## In Pursuit of Foldiness

### Intro

**Recursion is pretty cool**. This is a well-known fact that is widely accepted
to be a universal truth, and as functional programmers,
we tend to use this as the entry point of descent for new students into
the abyss of functional programming idiom. As it turns out, recursion
isn't just an entry point to functional programming, it is a fundamental
subject with impressive depth. This tutorial requires nothing but a familiarity
with what primitive recursion is

For example, if you understand this, then you're perfectly fine:

```
def fac(n: Int): Int =
  n match {
    case 0 | 1 => 1
    case n => n * fac(n - 1)
  }
```

**Functional programmers live on the moon**. This is a lesser-known fact that is
widely accepted to be universal truth, and as functional programmers, we tend
to fail pretty miserable at bridging the gap between the earth and the moon.
The last major attempt at bridging this gap ended up tragically with one of
us trying to build a rocket ship out of a burrito and that was generally considered
something we weren't going to try again, and so we stopped and started
telling students and people interested in learning more that they would have
to build their own rocket ship using the language of Category Theory without supervision.


**That was widely considered a bad move, and this tutorial attempts to build
your rocket ship for you in a linear way so that you can reach the moon.**

### Folds

`fold` is a standard operator that encapsulates a simple pattern of
recursion for processing recursive data structures, such as lists, or trees.
A quick test to understand how useful `fold` is can be would be to peruse
the Scala collections api and try and point to a function that isn't a fold.
Map? That's a `fold`. FlatMap? `fold`. Filter? Still a `fold`. Count, find,
scan, reduce? All `fold`s.

`fold` is not fake news. Let's take a look at the fundamental datastructure that
we'll treat in the pursuit of fold: The list.

##### Lists
For the purposes of this section, a list is defined in `Scala` (approximately)
thusly:

```
sealed trait List[+A]
final case object Nil extends List[Nothing]
final case class Cons[+A](head: A, tail: List[A]) extends List[A]
```

For a quick recap of the datastructure, notice that there are two possible
implementations of the List datatype: Nil - the empty list, and Cons (or :: ),
which represents a sub-list containing an element, and the rest of the list. Every
list may be constructed according to the following:

```
Cons(1, Cons(2, Cons(3, Nil)))  <=>  1 :: 2 :: 3 :: Nil
```


##### The `fold` Operator


Lets get started.

### Unfolds

### Abstracting Fold and Unfold
