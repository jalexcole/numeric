//import java.util.*
import numeric.*
import kotlin.system.measureTimeMillis

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