package destinationFaang.sortingAndSearching

// Leetcode 153
// 9hrs 44 mins
fun findMin(nums: IntArray): Int {
    var left = 0
    var right = nums.size - 1
    var ans = nums[0]

    if(nums.size == 1) {
        return nums[0]
    }

    while (left <= right) {
        if(nums[left] < nums[right]) {
            ans = minOf(nums[left], ans)
            break
        } else {
            val mid = left + (right - left)/2
            val midValue = nums[mid]

            if (nums[left] > midValue) {
                ans = minOf(nums[mid], ans)
                right = mid - 1
            } else {
                ans =  minOf(nums[left], ans)
                left = mid + 1
            }
        }
    }

    return ans
}


fun findMin2(nums: IntArray): Int {

    var left = 0
    var right = nums.size -1
    var ans = Int.MAX_VALUE

    while (left <=right) {
        if( nums[left] <= nums[right]) {
            ans = minOf(ans, nums[left])
            break
        }

        val mid = left + (right - left)/2
        val midValue = nums[mid]
        ans = minOf(ans, midValue)

        // left is sorted
        if(nums[left] < midValue){
            left = mid + 1
        } else {
            right = mid -1
        }
    }
    return ans
}

fun main() {
    println(findMin(intArrayOf(3,4,5,1,2)))
    //
    println(findMin2(intArrayOf(3,4,5,1,2)))
    println(findMin2(intArrayOf(4,5,6,7,0,1,2)))
    println(findMin2(intArrayOf(11,13,15,17)))
}


// time complexity = O(logN)
// space complexity = O(1)