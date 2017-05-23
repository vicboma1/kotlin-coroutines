
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking
import java.util.concurrent.atomic.AtomicInteger

/**
 * Created by vicboma on 23/05/17.
 */
class MainTestBasics5 {

    @org.junit.Before
    fun setUp() {

    }

    @org.junit.After
    fun tearDown() {

    }

    @org.junit.Test
    fun mainFail() = runBlocking<Unit> {
        val expected = 100000
        var result = StringBuilder()

        val list = List(100_000) {
            launch(CommonPool) {
                myFirstSuspending(result)
            }
        }

        list.forEach { it.join() }

        assert(expected.toString() != result.toString() )
    }

    suspend fun myFirstSuspending(result: StringBuilder) {
        delay(500L)
        result.append("a")
    }


    @org.junit.Test
    fun main() = runBlocking<Unit> {
        val expected = 100000
        var result = AtomicInteger()

        val list = List(100_000) {
            launch(CommonPool) {
                myFirstSuspending(result)
            }
        }

        list.forEach { it.join() }

        assert(expected == result.get() )
    }

    suspend fun myFirstSuspending(result: AtomicInteger) {
        delay(500L)
        result.incrementAndGet()
    }
}