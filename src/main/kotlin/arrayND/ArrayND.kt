package arrayND

import polynomial.Polynomial
import java.util.*
import kotlin.math.pow
import kotlin.math.sqrt

open class ArrayND {
  open var dataElements: Array<Double> = arrayOf()
  var shape: Array<Int> = arrayOf<Int>()
  var size: Int = dataElements.size
  
  constructor() {
    
  }
  
  constructor (ndArray: Array<Double>, shape: Array<Int>) {
    dataElements = ndArray
    this.shape = shape
  }
  
  constructor(ndArray: Array<Double>) {
    dataElements = ndArray
    shape = arrayOf(ndArray.size)
  }
  
  constructor(ndArray: ArrayList<Double>) {
    dataElements = ndArray.toTypedArray()
    shape = arrayOf(ndArray.size)
  }
  
  operator fun get(vararg indices: Int): ArrayND {
    val index = calculateIndex(indices.toTypedArray())
    return ArrayND(arrayOf(dataElements[index]))
  }
  operator fun get(indices: Array<Int>): ArrayND {
    val index = calculateIndex(indices)
    return ArrayND(arrayOf(dataElements[index]))
  }
  
  operator fun set(vararg indices: Int, value: Double) {
    val index = calculateIndex(indices.toTypedArray())
    dataElements[index] = value
  }
  
  operator fun set(indices: Array<Int>, value: Double) {
    val index = calculateIndex(indices)
    dataElements[index] = value
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
  
  fun single() = dataElements.single()
  
  fun reshape(newShape: Array<Int>): ArrayND {
    var count = 1
    for (i in newShape) {
      count *= i
    }
    if (count == dataElements.size) {
      shape = newShape
      return ArrayND(dataElements, newShape)
    } else {
      error("ValueError: cannot reshape array of size ${dataElements.size} into shape ${Arrays.toString(shape)}")
    }
  }
  
  private fun add(other: ArrayND): ArrayND {
    val x = arrayListOf<Double>()
    
    if (shape.contentEquals(other.getShape())) {
      for (i in 0 until size) {
        x.add(dataElements[i] + other.dataElements[i])
      }
       return ArrayND(x.toTypedArray(), shape)
      
    } else if(isScalar()) {
      for (i in 0 until other.size) {
        x += dataElements.single() + other.dataElements[i]
      }
      return ArrayND(x.toTypedArray(), other.shape)
      
    } else if(other.isScalar()) {
      for (i in 0 until size){
        x.add(dataElements[i] + other.single())
      }
      return ArrayND()
    }
    error("operator plus: nonconforming arguments")
  }
  
  operator fun plus(other: ArrayND) = add(other)
  
  operator fun plus(other: Double): ArrayND {
    val x = arrayListOf<Double>()
    for (i in dataElements) {
      x.add(i + other)
    }
    
    return ArrayND(x.toTypedArray(), this.shape)
  }
  
  operator fun minus(other: ArrayND): ArrayND {
    val x = arrayListOf<Double>()
  
    if (shape.contentEquals(other.getShape())) {
      for (i in 0 until size) {
        x.add(dataElements[i] - other.dataElements[i])
      }
      return ArrayND(x.toTypedArray(), shape)
    
    } else if(isScalar()) {
      for (i in 0 until other.size) {
        x += dataElements.single() - other.dataElements[i]
      }
      return ArrayND(x.toTypedArray(), other.shape)
    
    } else if(other.isScalar()) {
      for (i in 0 until size){
        x.add(dataElements[i] - other.single())
      }
      return ArrayND()
    }
    error("operator minus: nonconforming arguments")
  }
  
  
  operator fun minus(other: Double): ArrayND {
    val x = arrayListOf<Double>()
    for (i in dataElements) {
      x.add(i - other)
    }
  
    return ArrayND(x.toTypedArray(), this.shape)
  }
  
  operator fun unaryMinus(): ArrayND {
    val x = arrayListOf<Double>()
    for (i in dataElements) {
      x.add(i * -1)
    }
    return ArrayND(x.toTypedArray(), this.shape)
  }
  
  fun print() {
    when (shape.size) {
      1 -> {
        print("[")
        for (i in 0 until dataElements.size - 1) {
          print("$i, ")
        }
        print("${dataElements[dataElements.size - 1]}]")
      }
      2 -> {
        print("[")
        for (column in 0 until shape[0]) {
          if (column != 0) print(" ")
          print("[")
          for (row in 0 until shape[1]) {
            val index = shape[0] * column + row
            print(dataElements[index])
            if (row != shape[1] - 1) print(", ")
          }
          print("]")
          if (column != shape[0] - 1) print(",\n")
        }
        print("]")
      }
      3 -> {
      
      }
      0 -> {
        print("[]")
      }
      else -> {
        TODO("Make print work for all cases")
      }
    }
  }
  
  fun toPolynomial(): Polynomial {
    if (shape.size == 1) return Polynomial(dataElements)
    error("ShapeError: Array is a ${shape.size} dimension array")
  }
  
  fun isScalar(): Boolean {
    for(i in shape) {
      if (i != 1) return false
    }
    return true
  }
  
  
}

fun ArrayND.sum(): ArrayND {
  /**
   * Sum
   *
   * Takes the sum of every element in the array
   */
  var sum = 0.0
  for (i in dataElements) {
    sum += i
  }
  return ArrayND(arrayOf(sum))
}

fun ArrayND.pow(value: Double): ArrayND {
  val newList = arrayListOf<Double>()
  val newShape = shape
  for (i in 0 until dataElements.size) {
    newList.add(dataElements[i].pow(value))
  }
  return ArrayND(newList.toTypedArray(), newShape)
}

fun ArrayND.sqrt(): ArrayND {
  val newList = arrayListOf<Double>()
  val newShape = shape
  for (i in dataElements) {
    newList.add(sqrt(i))
  }
  return ArrayND(newList.toTypedArray(), newShape)
}

fun ArrayND.exp(array: Array<Double>): ArrayND {
  val x = ArrayList<Double>()
  for(i in array){
    x.add(kotlin.math.exp(i))
  }
  return ArrayND(x)
}