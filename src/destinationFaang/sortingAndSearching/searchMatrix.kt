package destinationFaang.sortingAndSearching

fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    val m = matrix.size // row
    val n = matrix[0].size
    var left = 0
    var right = m*n - 1

    while (left <= right) {
        val mid = left + (right - left)/2
        val midValRow = mid/n
        val midValCol = mid % n
        val midValue = matrix[midValRow][midValCol]

        when {
            midValue == target -> {
                return true
            }

            midValue > target -> {
                right = mid - 1
            }

            else -> {
                left = mid + 1
            }
        }
    }
    return false
}

fun main() {
    println(searchMatrix(arrayOf(intArrayOf(1,3,5,7), intArrayOf(10,11,16,20), intArrayOf(23,30,34,60)), target = 3))
}