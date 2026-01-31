package destinationFaang.twoPointer



class ThreeSum {

    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        if (nums.size == 0) return listOf()
        val result: MutableList<List<Int>> = mutableListOf<List<Int>>()

        for (i in nums.indices) {
            if (nums[i] > 0) break
            if( i == 0 || nums[i] != nums[i-1]) {
                twoSum(nums, i, result)
            }
        }
        return result
    }


    fun twoSum(nums: IntArray, i: Int, result: MutableList<List<Int>>) {
        var left = i+1
        var right = nums.size -1
        while (left < right) {
            val sum = nums[i] + nums[left] + nums[right]
            if(sum > 0) {
                right--
            } else if (sum < 0) {
                left++
            }
            else {
                result.add(listOf(nums[i], nums[left], nums[right]))
                left++
                right--
                while (left < right && nums[left] == nums[left-1]) {
                    left++
                }
            }
        }
    }
}

fun main() {
    println(ThreeSum().threeSum(intArrayOf(-1,0,1,2,-1,-4)))
//    println(ThreeSum().threeSum(intArrayOf(0,1,1)))
//    println(ThreeSum().threeSum(intArrayOf(0,0,0)))
}


// nums = [-4, -1, -1, 0, 1, 2]