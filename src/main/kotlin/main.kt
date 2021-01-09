import java.util.*

fun main(){
  val x = aRangeOf(49)
  x.print()
  println("")
  print("${Arrays.toString(x.shape)}")
  println("")
  val y = x.reshape(arrayOf(7, 7))
  y.print()
}