import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class MainKtTest {

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun add() {
        val postReturn = WallService.add(Post(11111, 22222, 33333, 44444, "Hello!"))
        val postReturn2 = WallService.add(Post(99999, 88888, 77777, 66666, "Bye!"))

        assertNotEquals(0, postReturn.id)
        assertNotEquals(0, postReturn2.id)
    }

    @Test
    fun updateTrue() {
        WallService.add(Post(11111, 22222, 33333, 44444, "Hello!"))
        WallService.add(Post(99999, 88888, 77777, 66666, "Bye!"))
        WallService.add(Post(55555, 44444, 66666, 88888, "Hi!"))

        val update = Post(99999, 88888, 77777, 66666, "Complete!", id = 2)

        val result = WallService.update(update)

        assertTrue(result)
    }

    @Test
    fun updateFalse() {
        WallService.add(Post(11111, 22222, 33333, 44444, "Hello!"))
        WallService.add(Post(99999, 88888, 77777, 66666, "Bye!"))
        WallService.add(Post(55555, 44444, 66666, 88888, "Hi!"))

        val update = Post(99999, 88888, 77777, 66666, "Complete!", id = 5)

        val result = WallService.update(update)

        assertFalse(result)
    }
}