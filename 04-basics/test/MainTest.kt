import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking

/**
 * Created by vicboma on 23/05/17.
 */
class MainTestBasics4 {

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
            myFirstSuspending(result)
        }

        result.append("Hello,\n")
        job.join()

        assert(expected.toString() == result.toString() )
    }

    suspend fun myFirstSuspending(result: StringBuilder) {
        delay(500L)
        result.append("World!")
    }
}