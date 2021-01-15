package arrayND

import polynomial.Polynomial
import kotlin.math.pow
import kotlin.math.sqrt

open class ArrayND {
  var elements: Array<Double> = arrayOf()
  var shape: Array<Int> = arrayOf<Int>()
  var size: Int
  
  constructor (ndArray: Array<Double>, shape: Array<Int>) {
    elements = ndArray
    this.shape = shape
    size = elements.size
  }
  
  constructor(ndArray: Array<Double>) {
    elements = ndArray
    shape = arrayOf(ndArray.size)
    size = elements.size
  }
  
  constructor(ndArray: ArrayList<Double>) {
    elements = ndArray.toTypedArray()
    shape = arrayOf(ndArray.size)
    size = elements.size
  }
  
  operator fun get(vararg indices: Int): ArrayND {
    val index = calculateIndex(indices.toTypedArray())
    return ArrayND(arrayOf(elements[index]))
  }
  operator fun get(indices: Array<Int>): ArrayND {
    val index = calculateIndex(indices)
    return ArrayND(arrayOf(elements[index]))
  }
  
  operator fun set(vararg indices: Int, value: Double) {
    val index = calculateIndex(indices.toTypedArray())
    elements[index] = value
  }
  
  operator fun set(indices: Array<Int>, value: Double) {
    val index = calculateIndex(indices)
    elements[index] = value
  }
  
  @JvmName("getSize1")
  fun getSize(): Int {
    size = elements.size
    return size
  }
  
  
  @JvmName("getShape1")
  fun getShape(): Array<Int> {
    return shape
  }
  
  private fun inBounds(shape: Array<Int>, indices: Array<Int>): Boolean {
    if (shape.size != indices.size) return false
    return shape.zip(indices).all { (s, i) -> s >= i }
  }
  
  private fun calculateIndex(indices: Array<Int>): Int {
    if (inBounds(shape, indices)) when (indices.size) {
      1 -> {
        return indices[0]
      }
      2 -> {
        val i = indices[0]
        val j = indices[1]
        return i * shape[0] + j
      }
      3 -> {
        val i = indices[0]
        val j = indices[1]
        val k = indices[2]
        
        return i * shape[0] * shape[1] + j * shape[1] + k
      }
      
      in 4 .. Int.MAX_VALUE -> {
        var index = 0
        for (i in 0 until shape.size - 1) {
          for (j in i until shape.size - 1) {
            index += indices[i] * shape[j]
          }
        }
        index += indices.last()
        
        return index
      }
      else -> return -1
    }
    return -1
  }
  
  fun single() = elements.single()
  
  fun reshape(newShape: Array<Int>): ArrayND {
    var count = 1
    for (i in newShape) {
      count *= i
    }
    if (count == elements.size) {
      return ArrayND(elements, newShape)
    } else {
      error("ValueError: cannot reshape array of size ${elements.size} into shape ${shape.contentDeepToString()}")
    }
  }
  
  fun reshape(vararg newShape: Int): ArrayND {
    var count = 1
    for (i in newShape) {
      count *= i
    }
    if (count == elements.size) {
      return ArrayND(elements, newShape.toTypedArray())
    } else {
      error("ValueError: cannot reshape array of size ${elements.size} into shape ${shape.contentDeepToString()}")
    }
  }
  
  
  
  
  operator fun plus(other: ArrayND): ArrayND {
    val x = arrayListOf<Double>()
  
    when {
      shape.contentEquals(other.getShape()) -> {
        for (i in 0 until elements.size) {
          x.add(elements[i] + other.elements[i])
        }
        return ArrayND(x.toTypedArray(), shape)
      }
      
      isScalar() -> {
        for (i in 0 until other.size) {
          x.add(elements.single() + other.elements[i])
        }
        return ArrayND(x.toTypedArray(), other.shape)
      }
      
      other.isScalar() -> {
        for (i in 0 until elements.size){
          x.add(elements[i] + other.single())
        }
        return ArrayND(x.toTypedArray())
      }
      else -> error("operator plus: nonconforming arguments")
    }
  }
  
  operator fun plus(other: Double): ArrayND {
    val x = arrayListOf<Double>()
    for (i in elements) {
      x.add(i + other)
    }
    
    return ArrayND(x.toTypedArray(), this.shape)
  }
  
  operator fun plus(other: Int): ArrayND {
    val x = arrayListOf<Double>()
    for (i in elements) {
      x.add(i + other)
    }
    
    return ArrayND(x.toTypedArray(), this.shape)
  }
  
  operator fun plus(other: Short): ArrayND {
    val x = arrayListOf<Double>()
    for (i in elements) {
      x.add(i + other)
    }
    
    return ArrayND(x.toTypedArray(), this.shape)
  }
  
  operator fun plus(other: Float): ArrayND {
    val x = arrayListOf<Double>()
    for (i in elements) {
      x.add(i + other)
    }
    
    return ArrayND(x.toTypedArray(), this.shape)
  }
  
  operator fun plus(other: Long): ArrayND {
    val x = arrayListOf<Double>()
    for (i in elements) {
      x.add(i + other)
    }
    
    return ArrayND(x.toTypedArray(), this.shape)
  }
  
  operator fun minus(other: ArrayND): ArrayND {
    val x = arrayListOf<Double>()
  
    if (shape.contentEquals(other.shape)) {
      for (i in 0 until elements.size) {
        x.add(elements[i] - other.elements[i])
      }
      return ArrayND(x.toTypedArray(), shape)
    
    } else if(isScalar()) {
      for (i in 0 until other.size) {
        x += elements.single() - other.elements[i]
      }
      return ArrayND(x.toTypedArray(), other.shape)
    
    } else if(other.isScalar()) {
      for (i in 0 until elements.size){
        x.add(elements[i] - other.single())
      }
      return ArrayND(x.toTypedArray())
    }
    error("operator minus: nonconforming arguments")
  }
  operator fun minus(other: Int): ArrayND {
    val x = arrayListOf<Double>()
    for (i in elements) {
      x.add(i - other)
    }
    
    return ArrayND(x.toTypedArray(), this.shape)
  }
  
  operator fun minus(other: Double): ArrayND {
    val x = arrayListOf<Double>()
    for (i in elements) {
      x.add(i - other)
    }
  
    return ArrayND(x.toTypedArray(), this.shape)
  }
  
  operator fun minus(other: Float): ArrayND {
    val x = arrayListOf<Double>()
    for (i in elements) {
      x.add(i - other)
    }
    
    return ArrayND(x.toTypedArray(), this.shape)
  }
  
  operator fun minus(other: Short): ArrayND {
    val x = arrayListOf<Double>()
    for (i in elements) {
      x.add(i - other)
    }
    
    return ArrayND(x.toTypedArray(), this.shape)
  }
  
  operator fun minus(other: Long): ArrayND {
    val x = arrayListOf<Double>()
    for (i in elements) {
      x.add(i - other)
    }
    
    return ArrayND(x.toTypedArray(), this.shape)
  }
  
  
  operator fun unaryMinus(): ArrayND {
    val x = arrayListOf<Double>()
    for (i in elements) {
      x.add(i * -1)
    }
    return ArrayND(x.toTypedArray(), this.shape)
  }
  operator fun times(other: Double): ArrayND {
    val x = arrayListOf<Double>()
    for (i in elements) {
      x.add(i * other)
    }
    return ArrayND(x.toTypedArray(), this.shape)
  }
  
  operator fun times(other: Int): ArrayND {
    val x = arrayListOf<Double>()
    for (i in elements) {
      x.add(i * other)
    }
    return ArrayND(x.toTypedArray(), this.shape)
  }
  
  operator fun times(other: Long): ArrayND {
    val x = arrayListOf<Double>()
    for (i in elements) {
      x.add(i * other)
    }
    return ArrayND(x.toTypedArray(), this.shape)
  }
  
  operator fun times(other: Short): ArrayND {
    val x = arrayListOf<Double>()
    for (i in elements) {
      x.add(i * other)
    }
    return ArrayND(x.toTypedArray(), this.shape)
  }
  
  operator fun times(other: Float): ArrayND {
    val x = arrayListOf<Double>()
    for (i in elements) {
      x.add(i * other)
    }
    return ArrayND(x.toTypedArray(), this.shape)
  }
  
  operator fun times(other: ArrayND): ArrayND {
    val x = arrayListOf<Double>()
  
    if (shape.contentEquals(other.getShape())) {
      for (i in 0 until size) {
        x.add(elements[i] * other.elements[i])
      }
      return ArrayND(x.toTypedArray(), shape)
    
    } else if(isScalar()) {
      for (i in 0 until other.size) {
        x += elements.single() * other.elements[i]
      }
      return ArrayND(x.toTypedArray(), other.shape)
    
    } else if(other.isScalar()) {
      for (i in 0 until size){
        x.add(elements[i] * other.single())
      }
      return ArrayND(x.toTypedArray())
    }
    error("operator *: nonconforming arguments")
  }
  
  operator fun div(other: Double): ArrayND {
    val x = arrayListOf<Double>()
    for (i in elements) {
      x.add(i / other)
    }
    return ArrayND(x.toTypedArray(), this.shape)
  }
  
  operator fun div(other: Float): ArrayND {
    val x = arrayListOf<Double>()
    for (i in elements) {
      x.add(i / other)
    }
    return ArrayND(x.toTypedArray(), this.shape)
  }
  
  operator fun div(other: Long): ArrayND {
    val x = arrayListOf<Double>()
    for (i in elements) {
      x.add(i / other)
    }
    return ArrayND(x.toTypedArray(), this.shape)
  }
  
  operator fun div(other: Short): ArrayND {
    val x = arrayListOf<Double>()
    for (i in elements) {
      x.add(i / other)
    }
    return ArrayND(x.toTypedArray(), this.shape)
  }
  
  operator  fun div(other: Int): ArrayND {
    val x = arrayListOf<Double>()
    for (i in elements) {
      x.add(i / other)
    }
    return ArrayND(x.toTypedArray(), this.shape)
  }
  
  operator fun div(other: ArrayND): ArrayND {
    val x = arrayListOf<Double>()
  
    if (shape.contentEquals(other.getShape())) {
      for (i in 0 until size) {
        x.add(elements[i] / other.elements[i])
      }
      return ArrayND(x.toTypedArray(), shape)
    
    } else if(isScalar()) {
      for (i in 0 until other.size) {
        x += elements.single() / other.elements[i]
      }
      return ArrayND(x.toTypedArray(), other.shape)
    
    } else if(other.isScalar()) {
      for (i in 0 until size){
        x.add(elements[i] / other.single())
      }
      return ArrayND(x.toTypedArray())
    }
    error("operator /: nonconforming arguments")
  }
  
  fun equals(other: ArrayND): Boolean {
    /**
     * Compares two values with the n-dimensional array
     */
    return (elements.contentEquals(other.elements)
            && shape.contentEquals(other.shape))
  }
  
  override fun toString(): String {
    var content = ""
    when (shape.size) {
      1 -> {
        content = elements.contentToString()
      }
      2 -> {
        content.plus("[")
        for (column in 0 until shape[0]) {
          if (column != 0) content.plus(" ")
          content.plus("[")
          for (row in 0 until shape[1]) {
            val index = shape[0] * column + row
            print(elements[index])
            if (row != shape[1] - 1) content.plus(", ")
          }
          content.plus("]")
          if (column != shape[0] - 1) content.plus(",\n")
        }
        content.plus("]")
      }
      3 -> {
      
      }
      0 -> {
        content.plus("[]")
      }
      else -> {
        TODO("Make print work for all cases")
      }
    }
    return content
  }
  
  fun toPolynomial(): Polynomial {
    if (shape.size == 1) return Polynomial(elements)
    error("ShapeError: Array is a ${shape.size} dimension array")
  }
  
  fun isScalar(): Boolean {
    for(i in shape) {
      if (i != 1) return false
    }
    return true
  }
  
  fun isVector(): Boolean {
    return (shape.size == 1)
  }
  
  fun isEmpty(): Boolean {
    return (shape.isEmpty())
  }
  fun sum(): ArrayND {
    /**
     * Sum
     *
     * Takes the sum of every element in the array
     */
    var sum = 0.0
    
    for (i in elements) {
      sum += i
    }
    
    return ArrayND(arrayOf(sum))
  }
  
  fun pow(value: Double): ArrayND {
    val newList = arrayListOf<Double>()
    val newShape = shape
    for (i in 0 until elements.size) {
      newList.add(elements[i].pow(value))
    }
    return ArrayND(newList.toTypedArray(), newShape)
  }
  
  fun sqrt(): ArrayND {
    val newList = arrayListOf<Double>()
    val newShape = shape
    for (i in elements) {
      newList.add(sqrt(i))
    }
    return ArrayND(newList.toTypedArray(), newShape)
  }
  
}



