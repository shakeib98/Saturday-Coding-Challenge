import javafx.util.Pair
import java.util.*

var array = arrayOf(
    arrayOf(1, 0, 0, 1),
    arrayOf(1, 0, 0, 1),
    arrayOf(1, 0, 0, 1),
    arrayOf(1, 0, 0, 1),
    arrayOf(1, 0, 0, 1)
)
var length = 0 //length of each line
var arrayLength = arrayListOf<Int>() //to hold the number of lines
var queue = LinkedList<Pair<Int, Int>>() //to hold the address of last visited vertex
var already = false

fun main(args: Array<String>) {
    countLines()
}

fun countLines() { //countlines funtion
    for (i in 0 until array.size) {
        for (j in 0 until array[i].size) {
            if (array[i][j] == 1) {
                array[i][j] = -1
                queue.add(Pair(i, j))
                length++
                while (true) {
                    if (!queue.isNullOrEmpty()) {
                        var i = queue[0].key
                        var j = queue[0].value
                        traverse(i, j)
                    }else{
                        arrayLength.add(length)
                        length=0
                        break
                    }
                }
                queue.clear()
            }
        }
    }
    printLength()
}

fun traverse(i: Int, j: Int) { //BFS function
    var i = i
    var j = j
//    queue.add(Pair(i, j))

    //to check the top
    if (i - 1 > -1) {
        if (array[i - 1][j] == 1) {
            array[i][j] = -1
            length++
            queue.add(Pair(i - 1, j))

        }
    }

    //to check left
     if (j - 1 > -1) {
        if (array[i][j - 1] == 1) {
            array[i][j - 1] = -1
            length++
            queue.add(Pair(i, j-1))

        }
    }

    //to check bottom
     if (i + 1 < array.size) {
        if (array[i + 1][j] == 1) {
            array[i + 1][j] = -1
            length++
            queue.add(Pair(i + 1, j))

        }
    }

    //to check right
     if (j + 1 < array[0].size) {
        if (array[i][j + 1] == 1) {
            array[i][j + 1] = -1
            length++
            queue.add(Pair(i, j+1))

        }
    }

    queue.remove()

}

fun printLength() { //To print length
    println("Number of lines are: ${arrayLength.size}")
    for (i in arrayLength) {
        println("Length of ${i+1} line is:")
        println(i)
    }
}