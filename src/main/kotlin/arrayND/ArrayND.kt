package arrayND

import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.pow



open class ArrayND {
    var dataND: ArrayList<Double> = arrayListOf()
    var shape: Array<Int> = arrayOf<Int>()
    
    
    
    constructor(){
    
    }

    constructor (ndArray: Array<Double>, shape: Array<Int>){
        dataND = arrayListOf(*ndArray)
        this.shape = shape
    }

    constructor(ndArray: Array<Double>) {
        dataND = arrayListOf(*ndArray)
        shape = arrayOf(ndArray.size)
    }

    constructor(ndArray: ArrayList<Double>){
        dataND = ndArray
        shape = arrayOf(ndArray.size)
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
        var index = -1
        if (inBounds(shape, indices)){
            when (indices.size) {
                1 ->{
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
                else -> return -1
            }
        }
        return -1
        
    
    }
    
    fun single() = dataND.single()
    
    fun reshape(newShape: Array<Int>): ArrayND {
        var count = 1
        for (i in newShape) {
            count *= i
        }
        if (count == dataND.size) {
            shape = newShape
            return ArrayND(dataND.toTypedArray(), newShape)
        } else {
            println("ValueError: cannot reshape array of size ${dataND.size} into shape ${Arrays.toString(shape)}")
            return  ArrayND()
        }
        
        
    }
    
    private fun add(b: ArrayND): ArrayND {
        return if (shape.contentEquals(b.getShape())){
            val x = arrayListOf<Double>()
            for(i in  0 until dataND.size){
                x.add(dataND[i] + b.dataND[i])
            }
            ArrayND(x.toTypedArray(), shape)
        } else {
            ArrayND(arrayOf<Double>(), arrayOf<Int>())
        }
    }

    operator fun plus(other: ArrayND) = add(other)
    
    operator fun plus(other: Double): ArrayND {
        val x = arrayListOf<Double>()
        for (i in dataND){
            x.add(i + other)
        }
        return ArrayND(x.toTypedArray(), this.shape)
    }

    fun print(){
        when(shape.size) {
            1 -> {
                print("[")
                for (i in 0 until dataND.size - 1) {
                    print("$i, ")
                }
                print("${dataND[dataND.size - 1]}]")
            }
            2 -> {
                print("[")
                for(column in 0 until shape[0]) {
                    if (column != 0) print(" ")
                    print("[")
                    for(row in 0 until shape[1]) {
                        val index = shape[0] * column + row
                        print(dataND[index])
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
    
    operator fun get(vararg args: Int): ArrayND {
        val index = calculateIndex(args.toTypedArray())
        return ArrayND(arrayOf(dataND[index].toDouble()))
    }
    
    operator fun set(vararg indices: Int, value: Double) {
        val index = calculateIndex(indices.toTypedArray())
        dataND[index] = value
    }
}

fun ArrayND.sum(): ArrayND {
    /**
     * Sum
     *
     * Takes the sum of every element in the array
     */
    var sum = 0.0
    for (i in dataND) {
        sum += i
    }
    return ArrayND(arrayOf(sum))
}

fun ArrayND.pow(value: Double): ArrayND {
    val newList = arrayListOf<Double>()
    val newShape = shape
    for (i in 0 until dataND.size){
        newList.add(dataND[i])
    }
    return ArrayND(newList.toTypedArray(), newShape)
}

fun ArrayND.sqrt(value: Double): ArrayND {
    val newList = arrayListOf<Double>()
    val newShape = shape
    
    for (i in 0 until dataND.size){
        newList.add(dataND[i].pow(2.0))
    }
    return ArrayND(newList.toTypedArray(), newShape)
}






