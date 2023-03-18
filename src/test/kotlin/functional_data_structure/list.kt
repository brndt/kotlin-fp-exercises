package functional_data_structure

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class ListTest {

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
}