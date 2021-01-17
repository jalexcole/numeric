package polynomial

import arrayND.ArrayND
import kotlin.math.pow


/**
 * Polynomial is a convenience class for handling polynomial functions
 */
class Polynomial(ndArray: Array<Double>): ArrayND(ndArray) {

  private fun polynomialResult(value: Double): Double {
    var sum = 0.0
    for (i in 0 until getSize()) {
      sum += elements[i] * value.pow(i.toDouble())
    }
    return sum
  }
  
  fun integrate(constant: Double = 0.0): Polynomial {
    var output = arrayListOf<Double>()
    
    output.add(constant)
    for (i in 1 until elements.size + 1) {
      output.add(elements[i - 1] / i)
    }
    
    return ArrayND(output.toTypedArray()).toPolynomial()
  }
  
  fun derivative(): ArrayND {
    val polyDerivative = arrayListOf<Double>()
    for (i in 1 until getSize()) {
      polyDerivative.add(elements[i] * i.toDouble())
    }
    return ArrayND(polyDerivative.toTypedArray())
  }
  
  operator fun invoke(value: Double): ArrayND {
    return ArrayND(arrayOf(polynomialResult(value)))
  }
  
  operator fun invoke(value: ArrayND): ArrayND {
    if (value.isScalar())
      return ArrayND(arrayOf(polynomialResult(value.single())))
    else if (value.isVector()) {
      val data = arrayListOf<Double>()
      for (i in 0 until value.getSize()) {
        data.add(polynomialResult(value[i].single()))
        return ArrayND(data.toTypedArray())
      }
      
    }
    error("ParameterError: input value is not a scalar")
  }
  
  operator fun plus(other: Polynomial): Polynomial = polynomialAdd(this, other)
  operator fun minus(other: Polynomial): Polynomial = polynomialSubtract(this,other)
  operator fun times(other: Polynomial): Polynomial = polynomialMultiply(this, other)
  operator fun div(other: Polynomial): Polynomial = polynomialDivide(this, other)
  
  fun toArrayND(): ArrayND = ArrayND(elements)
  
}