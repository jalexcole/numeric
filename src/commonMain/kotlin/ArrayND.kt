package numeric

class ArrayND  {
    var nDimensionalArray: ArrayList<Double> = arrayListOf()
    private var shape = arrayOf<Int>()

    constructor (ndArray: Array<Double>, shape: Array<Int>){
        nDimensionalArray = arrayListOf(*ndArray)
        this.shape = shape
    }

    constructor(ndArray: Array<Double>) {
        nDimensionalArray = arrayListOf(*ndArray)
        shape = arrayOf(ndArray.size)

    }

    private fun whatIsTheShape(): Array<Int> {
        return shape
    }

    fun add(b: ArrayND): ArrayND {
        if (shape.contentEquals(b.whatIsTheShape())){
            val x = arrayListOf<Double>()
            for(i in  0 until nDimensionalArray.size){
                x.add(nDimensionalArray[i] + b.nDimensionalArray[i])
            }
            return ArrayND(x.toTypedArray(), shape)
        }
        else {
            return ArrayND(arrayOf<Double>(), arrayOf<Int>())
        }
    }

    operator fun plus(other: ArrayND){
        add(other)
    }

    fun print(){
        TODO("Work in more than one dimension")
        print("[")
        for(i in nDimensionalArray) {
            print("$i ")
        }
        print("]")
    }
}

fun ArrayND.sum(): ArrayND {
    var sum = 0.0;
    for (i in nDimensionalArray) {
        sum += i
    }

    return ArrayND(arrayOf(sum), arrayOf(1))
}

fun arrange(count: Int){

}


fun array(array: Array<Double>): ArrayND {
    return ArrayND(array, arrayOf(array.size))
}

fun linspace(start: Double, stop: Double, steps: Int){

}


