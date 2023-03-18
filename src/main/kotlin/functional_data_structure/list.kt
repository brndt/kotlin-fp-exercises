package functional_data_structure

sealed class List<out A> {
    companion object {
        fun <A> of(vararg aa: A): List<A> {
            val tail = aa.sliceArray(1 until aa.size)
            return if (aa.isEmpty()) Nil else Cons(aa[0], of(*tail))
        }
    }
}
object Nil : List<Nothing>()
data class Cons<out A>(val head: A, val tail: List<A>) : List<A>()

/**
 * Implement the function tail for removing the first element of a List.
 */
fun <A> tail(xs: List<A>): List<A> = when (xs) {
    is Cons -> xs.tail
    else -> Nil
}

/**
 * Using the same idea as in the previous exercise, implement the function setHead for replacing
 * the first element of a List with a different value.
 */
fun <A> setHead(xs: List<A>, x: A): List<A> = when (xs) {
    is Nil -> Cons(x, Nil)
    else -> Cons(x, tail(xs))
}

/**
 * Generalize tail to the function drop, which removes the first n elements from a list.
 * Note that this function takes time proportional only to the number of elements being dropped—you
 * don’t need to make a copy of the entire List.
 */
tailrec fun <A> drop(list: List<A>, number: Int): List<A> {
        return if (number == 0) list
        else drop(tail(list), number - 1)
}