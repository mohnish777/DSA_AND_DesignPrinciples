package destinationFaang.sortingAndSearching

// find the first and the last position in the sorted array

// leetcode - 34 - 8hrs - 45 mins

fun searchRange(nums: IntArray, target: Int): IntArray {
    val first = findBound(nums, target, true)
    if(first == -1) {
        return intArrayOf(-1,-1)
    }

    val last = findBound(nums, target, false)


    return intArrayOf(first, last)

}

fun findBound(nums: IntArray, target: Int, isFirst: Boolean): Int {
    var start = 0
    var end = nums.size - 1

    while (start <= end) {
        val mid = start + (end - start) / 2

        if (nums[mid] == target) {
            if (isFirst) {
                if (start == mid || nums[mid-1] != target) {
                    return mid
                }
                end = mid - 1

            } else  {
                if (end == mid || nums[mid+1] != target) {
                    return mid
                }
                start = mid + 1
            }

        } else if (nums[mid] > target) {
            end = mid - 1
        } else {
            start = mid + 1
        }
    }

    return -1
}

fun main() {
    println(searchRange(intArrayOf(5,7,7,8,8,10), 8).contentToString())
    println(searchRange(intArrayOf(5,7,7,8,8,10), 6).contentToString())
    println(searchRange(intArrayOf(), 0).contentToString())
}


// time complexity = O(log n)