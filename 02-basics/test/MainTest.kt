import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking

/**
 * Created by vicboma on 23/05/17.
 */
class MainTestBasics2 {

    @org.junit.Before
    fun setUp() {

    }

    @org.junit.After
    fun tearDown() {

    }

    @org.junit.Test
    fun main() = runBlocking {
        val expected = StringBuilder("Hello,\nWorld!")

        var result = StringBuilder()

        launch(CommonPool) {
            delay(500L)
            result.append("World!")
        }
        result.append("Hello,\n")
        delay(500L)                 //<- Non-blocking main thread

        assert(expected.toString() == result.toString() )
    }

}