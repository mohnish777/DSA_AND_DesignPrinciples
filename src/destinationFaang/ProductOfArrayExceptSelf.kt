package destinationFaang

/* Leet code 238 - 2hrs
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
You must write an algorithm that runs in O(n) time and without using the division operation.
*/

fun productOfArrayExceptSelf(nums: IntArray): IntArray {
    val result = IntArray(nums.size) {1}

    var pre = 1
    var post = 1

    for (i in nums.indices) {
        result[i] = pre
        pre = nums[i]*pre
    }

    for (i in nums.size-1 downTo 0) {
        result[i] = result[i]*post
        post = nums[i]*post
    }

    return result

}