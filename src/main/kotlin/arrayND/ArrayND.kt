package arrayND

import kotlin.math.pow


open class ArrayND  {
    var nDimensionalArray: ArrayList<Double> = arrayListOf()
    var shape = arrayOf<Int>()
    
    constructor(){
    
    }

    constructor (ndArray: Array<Double>, shape: Array<Int>){
        nDimensionalArray = arrayListOf(*ndArray)
        this.shape = shape
    }

    constructor(ndArray: Array<Double>) {
        nDimensionalArray = arrayListOf(*ndArray)
        shape = arrayOf(ndArray.size)

    }

    constructor(ndArray: ArrayList<Double>){
        nDimensionalArray = ndArray
        shape = arrayOf(ndArray.size)
    }

    private fun whatIsTheShape(): Array<Int> {
        return shape
    }
    
    fun reshape(newShape: Array<Int>){
        var count = 1
        for (i in newShape) {
            count *= i
        }
        if (count == nDimensionalArray.size) {
            shape = newShape
        } else {
            print("New shape does not meet ArrayND size")
        }
    }
    
    private fun add(b: ArrayND): ArrayND {
        if (shape.contentEquals(b.whatIsTheShape())){
            val x = arrayListOf<Double>()
            for(i in  0 until nDimensionalArray.size){
                x.add(nDimensionalArray[i] + b.nDimensionalArray[i])
            }
            return ArrayND(x.toTypedArray(), shape)
        } else {
            return ArrayND(arrayOf<Double>(), arrayOf<Int>())
        }
    }

    operator fun plus(other: ArrayND) = add(other)
    
    operator fun plus(other: Double): ArrayND {
        val x = arrayListOf<Double>()
        for (i in nDimensionalArray){
            x.add(i + other)
        }
        return ArrayND(x.toTypedArray(), this.shape)
    }

    fun print(){
        when(shape.size) {
            1 -> {
                print("[")
                for (i in 0 until nDimensionalArray.size - 1) {
                    print("$i, ")
                }
                print("${nDimensionalArray[nDimensionalArray.size - 1]}]")
            }
            2 -> {
                print("[")
                for(column in 0 until shape[0]) {
                    print("[")
                    for(row in 0 until shape[1]) {
                        val index = row * column + row
                        print(nDimensionalArray[index])
                        if (row != shape[1] - 1) print(", ")
                    }
                    print("]")
                    if(column != shape[0] - 1) print(",\n")
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
    
    operator fun get(index: Int): Double{
        return nDimensionalArray[index]
    }
}

fun ArrayND.sum(): ArrayND {
    /**
     * Sum
     *
     * Takes the sum of every element in the array
     */
    var sum = 0.0;
    for (i in nDimensionalArray) {
        sum += i
    }
    return ArrayND(arrayOf(sum))
}

fun ArrayND.pow(value: Double): ArrayND {
    val newList = arrayListOf<Double>()
    val newShape = shape
    for (i in 0 until nDimensionalArray.size){
        newList.add(nDimensionalArray[i])
    }
    return ArrayND(newList.toTypedArray(), newShape)
}

fun ArrayND.sqrt(value: Double): ArrayND {
    val newList = arrayListOf<Double>()
    val newShape = shape
    
    for (i in 0 until nDimensionalArray.size){
        newList.add(nDimensionalArray[i].pow(2.0))
    }
    return ArrayND(newList.toTypedArray(), newShape)
}






