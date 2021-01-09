package arrayND

import java.util.*
import kotlin.collections.ArrayList
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

    fun getShapeInternal(): Array<Int> {
        return shape
    }
    
    fun stringShape(): String {
        var x:String = ""
        for (i in 0 until shape.size) {
            x.plus(i)
            if(i != shape.size) x.plus(", ")
        }
        return x
    }
    
    fun reshape(newShape: Array<Int>): ArrayND {
        var count = 1
        for (i in newShape) {
            count *= i
        }
        if (count == nDimensionalArray.size) {
            shape = newShape
            return ArrayND(nDimensionalArray.toTypedArray(), newShape)
        } else {
            print("ValueError: cannot reshape array of size ${nDimensionalArray.size} into shape ${Arrays.toString(shape)}")
            return  ArrayND()
        }
        
        
    }
    
    private fun add(b: ArrayND): ArrayND {
        if (shape.contentEquals(b.getShapeInternal())){
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
                    if (column != 0) print(" ")
                    print("[")
                    for(row in 0 until shape[1]) {
                        val index = shape[0] * column + row
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






