package destinationFaang.sortingAndSearching

import kotlin.math.max


// Leetcode 4
// 11hrs 15 mins
class MedianOfTwoSortedArrays {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray) : Double {
        if (nums1.size > nums2.size) {
            return findMedianSortedArrays(nums2, nums1)
        }
        val x = nums1.size
        val y = nums2.size
        var start = 0
        var end = x

        while (start<=end) {
            val partX = (start + end) / 2
            val partY = (x + y + 1)/2 - partX

            val xLeft = if(partX == 0) Int.MIN_VALUE else nums1[partX - 1]
            val xRight = if(partX == x) Int.MAX_VALUE else nums1[partX]
            val yLeft = if (partY == 0) Int.MIN_VALUE else nums2[partY - 1]
            val yRight = if (partY == y) Int.MAX_VALUE else nums2[partY]

            if (xLeft <= yRight && yLeft <= xRight) {
                if( (x+y) % 2 == 0) {
                    return (maxOf(xLeft, yLeft).toDouble() + minOf(xRight, yRight)) / 2
                } else {
                    return maxOf(xLeft, yLeft).toDouble()
                }
            } else if (xLeft > yRight) {
                end = partX - 1
            } else  {
                start  = partX + 1
            }
        }

        return 0.toDouble()
    }
}

fun main() {
    val solution = MedianOfTwoSortedArrays()

    println(solution.findMedianSortedArrays(intArrayOf(1,3), intArrayOf(2)))
    // Expected: 2.0

    println(solution.findMedianSortedArrays(intArrayOf(1,2), intArrayOf(3,4)))
    // Expected: 2.5

    println(solution.findMedianSortedArrays(intArrayOf(0,0), intArrayOf(0,0)))
    // Expected: 0.0

    println(solution.findMedianSortedArrays(intArrayOf(), intArrayOf(1)))
    // Expected: 1.0

    println(solution.findMedianSortedArrays(intArrayOf(2), intArrayOf()))
    // Expected: 2.0

    println(solution.findMedianSortedArrays(intArrayOf(1,3,8), intArrayOf(7,9,10,11)))
    // Expected: 8.0

    println(solution.findMedianSortedArrays(intArrayOf(1,2), intArrayOf(1,2,3)))
    // Expected: 2.0

    println(solution.findMedianSortedArrays(intArrayOf(-5,-3,-1), intArrayOf(-2)))
    // Expected: -2.5

    println(solution.findMedianSortedArrays(intArrayOf(1,1), intArrayOf(1,2)))
    // Expected: 1.0

    println(solution.findMedianSortedArrays(intArrayOf(100000), intArrayOf(100001)))
    // Expected: 100000.5

    println(solution.findMedianSortedArrays(intArrayOf(1,2,3,4,5,6), intArrayOf(7,8,9)))
// Expected: 5.0

    println(solution.findMedianSortedArrays(intArrayOf(1), intArrayOf(2,3,4,5,6,7,8,9)))
// Expected: 5.0
}


// time complexity = O(log(min(x,y))
// space complexity  = O(1)