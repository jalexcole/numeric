//import java.util.*
import kotlin.system.measureNanoTime
import kotlin.system.measureTimeMillis
import kotlin.time.microseconds
fun main(){
  simpleBenchmark()
}

fun simpleBenchmark(){
  val a = randomND(16000)
  val b = randomND(16000)
  val tic = measureTimeMillis {
    val x = dotProduct(a, b)
  }
  println("Dot product takes ${tic} milli-seconds")
}