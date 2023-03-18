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

fun <A> append(a1: List<A>, a2: List<A>): List<A> =
    when (a1) {
        is Nil -> a2
        is Cons -> Cons(a1.head, append(a1.tail, a2))
    }

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

/**
 * Implement dropWhile, which removes elements from the List prefix as long as they match a predicate.
 */
tailrec fun <A> dropWhile(l: List<A>, f: (A) -> Boolean): List<A> =
    when (l) {
        is Cons -> when (f(l.head)) {
            true -> dropWhile(l.tail, f)
            else -> l
        }

        else -> l
    }

/**
 * Implement a function, init, that returns a List consisting of all but the last element of a List.
 * So, given List(1, 2, 3, 4), init should return List(1, 2, 3).
 */
fun <A> init(list: List<A>): List<A> {
    tailrec fun <A> go(list: List<A>, accumulatedList: List<A>): List<A> =
        when (list) {
            is Cons -> when (list.tail) {
                is Cons -> go(list.tail, append(accumulatedList, List.of(list.head)))
                is Nil -> accumulatedList
            }
            else -> Nil
        }

    return go(list, Nil)
}