var arrayFinal = arrayOf<Int>(4,5,2,-12,8,9,6,1)
var hasComplimentHashSet = hashSetOf<Int>()
var sum =10
var arrayOfPairs = arrayListOf<Pair<Int,Int>>()

fun main(args: Array<String>) {
    printPairs(checkSumEqualsTo(arrayFinal))
}

fun printPairs(checkSumEqualsTo: ArrayList<Pair<Int, Int>>) {
    for(data in checkSumEqualsTo)
        println("[${data.first}, ${data.second}]")
}

fun checkSumEqualsTo(arrayFinal: Array<Int>):ArrayList<Pair<Int,Int>> {
    for(data in arrayFinal){
        if(hasComplimentHashSet.contains(data)) arrayOfPairs.add(Pair(sum-data,data))
        else hasComplimentHashSet.add(sum-data)
    }
    return arrayOfPairs
}