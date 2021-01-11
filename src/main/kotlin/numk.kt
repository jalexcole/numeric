


import arrayND.ArrayND
import kotlin.*
import kotlin.math.exp

fun aRangeOf(count: Int): ArrayND {
    val x: ArrayList<Double> = ArrayList()
    for(i in 0 until count){
        x.add(i.toDouble())
    }
    return ArrayND(x)
}

fun arrayNDOf(vararg array: Double): ArrayND {
    return ArrayND(array.toTypedArray())
}

fun arrayNDOf(array: Array<Double>): ArrayND {
    return ArrayND(array, arrayOf(array.size))
}

fun linspace(start: Double, stop: Double, steps: Int=50): ArrayND {
    val stepSize = (stop - start) / (steps.toDouble() - 1)
    val linspaceArray = arrayListOf<Double>()
    
    linspaceArray.add(start)
    for (i in 1 until steps) {
        linspaceArray.add(start + stepSize * i)
    }
    return ArrayND(linspaceArray.toTypedArray())
}

fun zeros(size: Int): ArrayND {
    val newArray = arrayListOf<Double>()
    for (i in 0 until size) {
        newArray.add(0.0)
    }
    return ArrayND(newArray.toTypedArray(), arrayOf(size))
}

fun zeros(sizeA: Array<Int>){

}