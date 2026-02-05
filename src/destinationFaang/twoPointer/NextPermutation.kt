package destinationFaang.twoPointer

// Leetcode 31
// 6hr: 40 mins
class NextPermutation {
    fun nextPermutation(nums: IntArray): IntArray {
        val n = nums.size
        var index = -1

        for (i in n-2 downTo 0) {
            if (nums[i] < nums[i+1]) {
                index = i
                break
            }
        }

        // if no break point reverse the array
        if (index == -1) {
            nums.reverse()
            return nums
        }

        // find element just greater than nums[index]
        for (i in n-1 downTo index +1) {
            if (nums[i] > nums[index]) {
                val temp = nums[i]
                nums[i] = nums[index]
                nums[index] = temp
                break
            }
        }

        // reverse the suffix
        reverseSuffix(nums, index+1, n-1)


        return nums
    }

    fun reverseSuffix(nums: IntArray, start: Int, end: Int) {
        var l = start
        var r = end
        while (l < end) {
            val temp = nums[l]
            nums[l] = nums[r]
            nums[r] = temp
            l++
            r--
        }
    }
}


fun main() {
    println(NextPermutation().nextPermutation(intArrayOf(1, 2, 3, 4, 5)).contentToString())
    println(NextPermutation().nextPermutation(intArrayOf(3, 2, 1)).contentToString())
    println(NextPermutation().nextPermutation(intArrayOf(3)).contentToString())
}


// time complexity = O(3N) = O(N)

// space complexity = O(1)