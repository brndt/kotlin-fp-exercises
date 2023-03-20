package functional_data_structure

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class ListTest {

    @Test
    fun `test setHead function when list has five elements`() {
        val expected = List.of(3, 3, 1, 5, 9)
        assertEquals(expected, setHead(List.of(5, 3, 1, 5, 9), 3))
    }

    @Test
    fun `test setHead function when list has zero elements`() {
        val expected = List.of(3)
        assertEquals(expected, setHead(Nil, 3))
    }

    @Test
    fun `test drop function when it has five elements`() {
        val expected = List.of(6, 4)
        assertEquals(expected, drop(List.of(1, 5, 3, 6, 4), 3))
    }

    @Test
    fun `test drop function when it has zero elements`() {
        val expected = Nil
        assertEquals(expected, drop(Nil, 3))
    }

    @Test
    fun `test tail function when it has five elements`() {
        val expected = List.of(5, 3, 6, 4)
        assertEquals(expected, tail(List.of(1, 5, 3, 6, 4)))
    }

    @Test
    fun `test tail function when it has zero elements`() {
        val expected = Nil
        assertEquals(expected, tail(Nil))
    }

    @Test
    fun `test dropWhile function when it receives non empty list`() {
        val expected = List.of(5, 3, 6, 4)
        assertEquals(expected, dropWhile(List.of(4, 5, 3, 6, 4)) { a -> a % 2 == 0 })
    }

    @Test
    fun `test init function when it receives non empty list`() {
        val expected = List.of(4, 5, 3, 6)
        assertEquals(expected, init(List.of(4, 5, 3, 6, 4)))
    }

    @Test
    fun `test init function when it receives empty list`() {
        val expected = Nil
        assertEquals(expected, init(Nil))
    }
}