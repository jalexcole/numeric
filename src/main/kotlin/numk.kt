


import arrayND.ArrayND
import kotlin.*
import kotlin.math.exp

fun aRangeOf(count: Int): ArrayND {
    val x: ArrayList<Double> = ArrayList()
    for(i in 0..count){
        x.add(i.toDouble())
    }
    return ArrayND(x)
}


fun arrayND(array: Array<Double>): ArrayND {
    return ArrayND(array, arrayOf(array.size))
}

fun arrayND(arrayList: ArrayList<Double>): ArrayND {
    return ArrayND(arrayList)
}

fun linspace(start: Double, stop: Double, steps: Int=50) {

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

fun exp(array: Array<Double>): ArrayND {
    val x = ArrayList<Double>()
    for(i in array){
        x.add(exp(i))
    }
    return ArrayND(x)
}