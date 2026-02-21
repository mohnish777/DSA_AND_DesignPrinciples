package destinationFaang.sortingAndSearching

// leetcode - 704
// 8hrs 20 mins

fun binarySearch(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.size -1

    while (left <= right) {

        val mid  = left + (right - left)/2
        when {
            nums[mid] == target -> return mid
            nums[mid] > target -> right  = mid - 1
            else ->  left = mid + 1
        }
    }
    return -1
}

fun main() {
    println(binarySearch(intArrayOf(-1,0,3,5,9,1), 9))
    println(binarySearch(intArrayOf(-1,0,3,5,9,12), 2))
}

// time complexity = O(log n)