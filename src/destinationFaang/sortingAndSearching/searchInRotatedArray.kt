package destinationFaang.sortingAndSearching


// leetcode 33
// 9hrs 55 mins
fun searchInRotatedArray(nums: IntArray, target: Int): Int {

    var left = 0
    var right = nums.size - 1

    while (left <= right) {
        val mid = left + (right - left)/2

        if (nums[mid] == target) return mid

        if (nums[left] < nums[mid]) {
            if (target < nums[left] || target > nums[mid]) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        } else {
            if (target < nums[mid] || target > nums[right]) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
    }

    return -1

}

// time complexity O(logN)
// space complexity O(1)