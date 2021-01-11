package polynomial

import arrayND.ArrayND
import kotlin.math.pow


/**
 * Polynomial is a convenience class for handling polynomial functions
 */
class Polynomial(elements: Array<Double>): ArrayND() {
  override var dataElements = elements

  fun polynomialResult(value: Double): Double {
    var sum = 0.0
    for (i in 0 until size) {
      sum += dataElements[i] * value.pow(i.toDouble())
    }
    return sum
  }
  
  operator fun invoke(value: Double): ArrayND {
    return ArrayND(arrayOf(polynomialResult(value)))
  }
  
  operator fun invoke(value: ArrayND): ArrayND {
    if(value.isScalar()) return ArrayND(arrayOf(polynomialResult(value.single())))
    error("ParameterError: input value is not a scalar")
  }
}