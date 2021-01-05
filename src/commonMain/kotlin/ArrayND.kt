

class ArrayND  {
    var nDimensionalArray: ArrayList<Double> = arrayListOf()
    var dimensionalInfo = arrayOf<Int>()

    constructor (ndArray: Array<Double>, shape: Array<Int>){
        nDimensionalArray = arrayListOf(*ndArray)
        dimensionalInfo = shape
    }
    fun array(array: Array<Double>){
        nDimensionalArray = arrayListOf<Double>(*array)
        dimensionalInfo = arrayOf(array.size)
    }

    fun shape(): Array<Int> {
        return dimensionalInfo
    }

    fun setShape(array: Array<Int>){
        dimensionalInfo = array
    }

    fun setA(array: Array<Double>){
        nDimensionalArray = arrayListOf<Double>(*array)
    }

    fun add(b: ArrayND): ArrayND {
        if (dimensionalInfo == b.shape()){
            val x = arrayOf<Double>()
            for(i in nDimensionalArray.indices){
                x[i] = nDimensionalArray[i] + b.nDimensionalArray[i]
            }
            return ArrayND(x, dimensionalInfo)
        }
        else {
            return ArrayND(arrayOf<Double>(), arrayOf<Int>())
        }
    }

    operator fun plus(b: ArrayND){
        add(b)
    }



}

fun linspace(start: Double, stop: Double, steps: Int){

}


