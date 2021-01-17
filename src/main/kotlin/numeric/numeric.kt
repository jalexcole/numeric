package numeric


import arrayND.ArrayND
import kotlin.*
import kotlin.random.Random as Random

object numeric {
  fun aRangeOf(count: Int): ArrayND {
    val x: ArrayList<Double> = ArrayList()
    for (i in 0 until count) {
      x.add(i.toDouble())
    }
    return ArrayND(x.toTypedArray())
  }
  
  fun arrayNDOf(vararg array: Double): ArrayND {
    return ArrayND(array.toTypedArray())
  }
  
  fun arrayNDOf(array: Array<Double>): ArrayND {
    return ArrayND(array, arrayOf(array.size))
  }
  
  fun arrayNDOf(): ArrayND = ArrayND(arrayOf(), arrayOf())
  
  fun linspace(start: Double, stop: Double, steps: Int = 50): ArrayND {
    val stepSize = (stop - start) / (steps.toDouble() - 1)
    val linspaceArray = arrayListOf<Double>()
    
    linspaceArray.add(start)
    for (i in 1 until steps) {
      linspaceArray.add(start + stepSize * i)
    }
    return ArrayND(linspaceArray.toTypedArray())
  }
  
  fun randomND(vararg args: Int): ArrayND {
    var count = 1
    for (i in args) {
      count *= i
    }
    
    val randomArrayND = DoubleArray(count) { Random.nextDouble() }.asList()
    return ArrayND(randomArrayND.toTypedArray(), args.toTypedArray())
  }
  
  fun randomND(values: Array<Int>): ArrayND {
    var count: Int = 1
    for (i in values) {
      count *= i
    }
    
    val randomArrayND = DoubleArray(count) { Random.nextDouble() }.asList()
    return ArrayND(randomArrayND.toTypedArray(), values)
  }
  
  fun dotProduct(a: ArrayND, b: ArrayND): ArrayND {
    return (a * b).sum()
  }
  
  fun zeros(size: Int): ArrayND {
    val newArray = arrayListOf<Double>()
    for (i in 0 until size) {
      newArray.add(0.0)
    }
    return ArrayND(newArray.toTypedArray(), arrayOf(size))
  }
}



