package destinationFaang.sortingAndSearching

// Dutch national flag algo
// Leetcode - 9: hrs - 22mins
class sortColors {
    fun sortColors(nums: IntArray) {
        var low = 0
        var high = nums.size -1
        var current = 0

        while (current <= high) {
            if (nums[current] == 0) {
                swap(nums, current, low)
                low++
                current++
            } else if (nums[current] == 2) {
                swap(nums, current, high)
                high--
            } else {
                current++
            }
        }
    }

    fun swap(nums: IntArray, i: Int, j: Int) {
        val temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
    }
}

// time complexity = O(N)
// space complexity  = O(1)