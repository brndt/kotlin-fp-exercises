package general

val <T> List<T>.tail: List<T>
    get() = drop(1)
val <T> List<T>.head: T
    get() = first()

fun <A> isSorted(aa: List<A>, order: (A, A) -> Boolean): Boolean {
    tailrec fun <A> go(aa: List<A>, order: (A, A) -> Boolean): Boolean =
        when {
            aa.tail.isEmpty() -> true
            order(aa.head, aa.tail.head) -> go(aa.tail, order)
            else -> false
        }
    return go(aa, order)
}