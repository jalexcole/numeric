package polynomial

import arrayND.ArrayND
import kotlin.math.pow


/**
 * Polynomial is a convenience class for handling polynomial functions
 */
class Polynomial(ndArray: Array<Double>): ArrayND(ndArray) {

  private fun polynomialResult(value: Double): Double {
    var sum: Double = 0.0
    for (i in 0 until size) {
      sum += dataElements[i] * value.pow(i.toDouble())
    }
    return sum
  }
  
  fun derivative(): ArrayND {
    val polyDerivative = arrayListOf<Double>()
    for (i in 1 until size) {
      polyDerivative.add(dataElements[i] * i.toDouble())
    }
    return ArrayND(polyDerivative.toTypedArray())
  }
  
  operator fun invoke(value: Double): ArrayND {
    return ArrayND(arrayOf(polynomialResult(value)))
  }
  
  operator fun invoke(value: ArrayND): ArrayND {
    if(value.isScalar()) return ArrayND(arrayOf(polynomialResult(value.single())))
    error("ParameterError: input value is not a scalar")
  }
  
  fun toArrayND(): ArrayND = ArrayND(dataElements)
  
}