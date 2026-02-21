package destinationFaang.sortingAndSearching

// Leetcode 169
// 9hrs 25 mins
fun majorityElement(nums: IntArray):Int {
    val counts = HashMap<Int, Int>()
    val majorityConstraint = nums.size/2
    for(num in nums) {
        counts[num] = counts.getOrDefault(num, 0) + 1
        if (counts[num]!! > majorityConstraint) {
            return num
        }
    }
    return nums[1]
}



fun main() {
    println(majorityElement(intArrayOf(3,2,3)))
    println(majorityElement(intArrayOf(2,2,1,1,1,2,2)))
}


// time complexity 0(N)
// space O(N)