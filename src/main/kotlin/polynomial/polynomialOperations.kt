package polynomial

import arrayND.ArrayND

fun Polynomial.polynomialAdd(self: Polynomial, other: Polynomial): Polynomial {
  var output = DoubleArray(if(self.elements.size > other.elements.size) self.elements.size else other.elements.size)
  
  for (i in output.indices) {
    output[i] = 0.0
  }
  for(i in self.elements.indices) {
    output[i] += self.elements[i]
  }
  for(i in other.elements.indices) {
    output[i] += other.elements[i]
  }
  
  return ArrayND(output.toTypedArray()).toPolynomial()
}

fun Polynomial.polynomialSubtract(self: Polynomial, other: Polynomial): Polynomial {
  var output = DoubleArray(
    if(self.elements.size > other.elements.size) self.elements.size
    else other.elements.size)
  
  for (i in output.indices) {
    output[i] = 0.0
  }
  for(i in self.elements.indices) {
    output[i] += self.elements[i]
  }
  for(i in other.elements.indices) {
    output[i] -= other.elements[i]
  }
  
  return ArrayND(output.toTypedArray()).toPolynomial()
}

fun Polynomial.polynomialMultiply(self: Polynomial, other: Polynomial): Polynomial {
  
  var output = DoubleArray(self.elements.size + other.elements.size - 1)
  
  for (i in output.indices){
    output[i] = 0.0
  }
  
  for (i in 0 until self.elements.size) {
    for (j in 0 until other.elements.size)
      output[i + j] = self.elements[i] * other.elements[j]
  }
  
  return ArrayND(output.toTypedArray()).toPolynomial()
}

fun Polynomial.polynomialDivide(self: Polynomial, other: Polynomial): Polynomial {
  
  var output = DoubleArray(self.elements.size + other.elements.size - 1)
  
  for (i in output.indices){
    output[i] = 0.0
  }
  
  for (i in 0 until self.elements.size) {
    for (j in 0 until other.elements.size)
      if (self.elements[i] == 0.0 || other.elements[j] == 0.0){
        output[i + j] +=  0.0
      } else {
        output[i + j] += self.elements[i] * other.elements[j]
      }
  }
  return ArrayND(output.toTypedArray()).toPolynomial()
}