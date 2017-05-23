import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking

/**
 * Created by vicboma on 23/05/17.
 */
class MainTestBasics3 {

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

        val job = launch(CommonPool) {
            delay(500L)
            result.append("World!")
        }
        result.append("Hello,\n")
        job.join()                 //<-   waiting to coroutine completes

        assert(expected.toString() == result.toString() )
    }

}