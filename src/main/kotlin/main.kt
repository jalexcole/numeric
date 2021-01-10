import java.util.*

fun main(){
  val x = aRangeOf(49)
  x.print()
  println("")
  print("${Arrays.toString(x.shape)}")
  println("")
  val y = x.reshape(arrayOf(7, 7))
  y.print()
  
  y[3, 4] = 777.0
  println("\n\n ${y[3, 4].single()}")
  y.print()
}