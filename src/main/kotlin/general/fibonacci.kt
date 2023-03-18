package general

fun fib(n: Int): Int {
    tailrec fun go(j: Int, current: Int, next: Int): Int {
        return if (j == n) current
        else go(j + 1, next, current + next)
    }
    return go(1, 0, 1)
}