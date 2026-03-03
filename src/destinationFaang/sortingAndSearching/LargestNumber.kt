package destinationFaang.sortingAndSearching

import kotlin.math.ceil

class LargestNumber {

    fun largestNumber(nums: IntArray): String {
        // convert ints to str
        val arr: MutableList<String> = nums.map { it.toString() }.toMutableList()

        arr.sortWith { a, b ->
            val ab = a+b
            val ba = b+a

            when {
                ab > ba -> -1
                ab < ba -> 1
                else -> 1
            }
        }

        if (arr[0] == "0") return "0"

        return arr.joinToString("")
    }

    fun largestNumber2(nums: IntArray): String {

        val arr: MutableList<String> = nums.map { it.toString() }.toMutableList()

        for (i in 0 until arr.size){
            for (j in 0 until arr.size - 1 - i) {
                val a  = arr[j]
                val b = arr[j+1]
                if (a + b < b + a) {
                    arr[j] = b
                    arr[j+1] = a
                }
            }
        }

        if (arr[0] == "0") return "0"

        return arr.joinToString("")

    }

}

fun main() {
    println(ceil(3.0 / 6))
    val sol = LargestNumber()

    val tests = listOf(
        intArrayOf(10, 2),                 // simple
        intArrayOf(3, 30, 34, 5, 9),        // classic example
        intArrayOf(1),                     // single element
        intArrayOf(0, 0),                  // all zeros
        intArrayOf(0, 0, 0, 0),             // many zeros
        intArrayOf(12, 121),               // tricky prefix case
        intArrayOf(8308, 830),              // tricky lexicographic case
        intArrayOf(432, 43243),             // prefix trap
        intArrayOf(9, 91, 90, 99),          // multiple 9-prefixed
        intArrayOf(8, 7, 1, 2, 3, 4, 5, 6),  // shuffled input
        intArrayOf(20, 1),                  // 201 vs 120
        intArrayOf(121, 12, 120),           // multiple prefix overlaps
    )

    for (test in tests) {
        println("${test.toList()} -> ${sol.largestNumber2(test)}")
    }
}

// 2nd approach
// time complexity = O(N) + N log(N) + O(N) = NlogN
// space complexity = O(N)