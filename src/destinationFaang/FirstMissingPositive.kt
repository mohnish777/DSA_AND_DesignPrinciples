package destinationFaang

import kotlin.math.abs

// leetcode - 41. First Missing Positive
// 3hrs 20 mins
fun firstMissingPositive(nums: IntArray): Int {
    val n = nums.size

    //check if one exists
    var containsOne = false
    for (i in nums.indices) {
        if (nums[i]==1) {
            containsOne = true
            break
        }
    }
    if (!containsOne) return 1

    // Step 2: Replace invalid numbers with 1
    for (i in 0 until nums.size) {
        if (nums[i]<=0 || nums[i] > n) {
            nums[i] = 1
        }
    }

    // Step 3: Mark presence using index sign
    for (i in 0 until n) {
        val a  = abs(nums[i])
        if (a == n){
            nums[0] = -abs(nums[0])
        } else {
            nums[a] = -abs(nums[a])
        }
    }

    // find the first positive index
    for (i in 1 until n) {
        if (nums[i]>0) {
            return i
        }
    }

    // worst case - for array [1,2,3,4,5,7], converted to [1, -2, -3, -4, -5, -1]
    if (nums[0] > 0) {
        return n
    }

    // all numbers exist [1,2,3,4,5,6]

    return n+1

}


fun main() {
    println(firstMissingPositive(intArrayOf(1,2,3,4,5,7)))
    println(firstMissingPositive(intArrayOf(3,4,-1,1)))
}