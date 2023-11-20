import kotlinx.coroutines.*

suspend fun main(){
    val alarm1 = Alarm(5, "Ring")
    val alarm2 = Alarm(7, "Click")
    val alarm3 = Alarm(10, "Smash")

    coroutineScope {
        launch { alarm1.start() }
        launch { alarm2.start() }
        launch { alarm3.start() }
    }
}

class Alarm(private val seconds: Int, private val sound: String) {
    suspend fun start() {
        for (i in 0..< seconds - 1){
            delay(1000)
            println("$sound (${i + 1})")
        }
        delay(1000)
        println("$sound ($seconds) = BOOM")
    }
}