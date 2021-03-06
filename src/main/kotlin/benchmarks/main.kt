//import java.util.*
import numeric.*
import kotlin.system.measureTimeMillis

fun main(){
  simpleBenchmark()
}

fun simpleBenchmark(){
  val a = numeric.randomND(16000)
  val b = numeric.randomND(16000)
  var x = ""
  val tic = measureTimeMillis {
     x = numeric.dotProduct(a, b).toString()
  }
  println("Dot product $x takes ${tic} milli-seconds")
}