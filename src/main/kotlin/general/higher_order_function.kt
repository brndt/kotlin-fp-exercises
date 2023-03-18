package general

/**
 *  Implement currying, which converts a function f of two arguments into a function with one argument that partially applies f.
 */
fun <A, B, C> curry(f: (A, B) -> C): (A) -> (B) -> C =
    { a: A -> { b: B -> f(a, b) } }

/**
 * Implement uncurry, which reverses the transformation of curry. Note that since -> associates to the right,
 * (A) -> ((B) -> C) can be written as (A) -> (B) -> C.
 */
fun <A, B, C> uncurry(f: (A) -> (B) -> C): (A, B) -> C =
    { a: A, b: B -> f(a)(b) }

/**
 * Implement the HOF that composes two functions.
 */
fun <A, B, C> compose(f: (B) -> C, g: (A) -> B): (A) -> C =
    { a: A -> f(g(a)) }