package general

/**
 * Write a recursive function to get the nth Fibonacci number. The first two Fibonacci numbers are 0 and 1.
 * The nth number is always the sum of the previous two—the sequence begins 0, 1, 1, 2, 3, 5, 8, 13, 21.
 * Your definition should use a local tail-recursive function.
 */
fun fib(n: Int): Int {
    tailrec fun go(j: Int, current: Int, next: Int): Int {
        return if (j == n) current
        else go(j + 1, next, current + next)
    }
    return go(1, 0, 1)
}