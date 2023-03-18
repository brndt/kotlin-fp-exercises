package general

val <T> List<T>.tail: List<T>
    get() = drop(1)
val <T> List<T>.head: T
    get() = first()

/**
 * Implement isSorted, which checks whether a singly linked list List<A> is sorted according to a given
 * comparison function. The function is preceded by two extension properties that add head and tail to
 * any List value. The head property returns the first element of the list, while tail returns all subsequent
 * elements as another List<A>.
 */
fun <A> isSorted(aa: List<A>, order: (A, A) -> Boolean): Boolean {
    tailrec fun <A> go(aa: List<A>, order: (A, A) -> Boolean): Boolean =
        when {
            aa.tail.isEmpty() -> true
            order(aa.head, aa.tail.head) -> go(aa.tail, order)
            else -> false
        }
    return go(aa, order)
}