package destinationFaang.twoPointer

// Leet code 26
// 6hrs : 30 mins
class RemoveDuplicates {
    fun removeDuplicates(nums: IntArray): Int {
        var index = 1
        for ( i in 1 until nums.size) {
            if(nums[i-1] !=nums[i]) {
                nums[index] = nums[i]
                index++
            }
        }
        return index
    }
}


fun main() {
    val removeDuplicates = RemoveDuplicates()
    println(removeDuplicates.removeDuplicates(intArrayOf(1,2,3,4,5)))
    println(removeDuplicates.removeDuplicates(intArrayOf(1,2,3,4,5)))
    println(removeDuplicates.removeDuplicates(intArrayOf(1,1,2)))
}