
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch

/**
 * Created by vicboma on 23/05/17.
 */
object Main {

    @JvmStatic fun main(args: Array<String> ){
        launch(CommonPool) {
            delay(500L)
            println("World!")
        }
        println("Hello,")
        Thread.sleep(500L)
    }
}