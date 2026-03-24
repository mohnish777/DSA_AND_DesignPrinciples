package destinationFaang.LinkedList

// Leetcode - 287
// 13hrs 05 mins
class FindDuplicateValue {

    fun findDuplicate(nums: IntArray): Int {
        var slow = nums[0]
        var fast = nums[0]

        // detect the cycle
        /*
        * slow moves 1 step, fast moves 2 steps
          In worst case, they meet after O(n) steps
        *
        * */
        do {
            slow = nums[slow]
            fast = nums[nums[fast]]
        } while (slow != fast)

        // find entrance of the cycle

        /*
        * Both move 1 step
          Takes at most O(n)
        * */
        slow = nums[0]
        while (slow != fast) {
            slow = nums[slow]
            fast = nums[fast]
        }

        return slow
    }
}

// time complexity = O(N) + O(N) = O(N)
// space complexity = O(1)