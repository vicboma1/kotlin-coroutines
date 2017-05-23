import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch

/**
 * Created by vicboma on 23/05/17.
 */
class MainTestBasics1 {

    @org.junit.Before
    fun setUp() {

    }

    @org.junit.After
    fun tearDown() {

    }

    @org.junit.Test
    fun main()  {
        val expected = StringBuilder("Hello,\nWorld!")

        var result = StringBuilder()

        launch(CommonPool) {
            delay(500L)
            result.append("World!")
        }
        result.append("Hello,\n")
        Thread.sleep(500L)         //<- Block main thread

        assert(expected.toString() != result.toString() )
    }

}