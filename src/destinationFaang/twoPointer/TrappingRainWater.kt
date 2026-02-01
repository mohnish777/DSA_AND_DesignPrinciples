package destinationFaang.twoPointer

// Leetcode - 42
// 6hrs: 20 mins
class TrappingRainWater {

    fun trappingRainWater(height : IntArray) : Int {
        var left = 0
        var right = height.size -1
        var leftMax = height[0]
        var rightMax = height[right]
        var total = 0

        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = maxOf(leftMax, height[left])
                if (leftMax - height[left] > 0) {
                    total = total + (leftMax - height[left])
                }
                left++
            } else {
                rightMax = maxOf(rightMax, height[right])
                if (rightMax - height[right] > 0) {
                    total = total + (rightMax - height[right])
                }
                right--
            }
        }
        return total
    }
}

fun main() {
    println(TrappingRainWater().trappingRainWater(intArrayOf(0,1,0,2,1,0,1,3,2,1,2,1)))
    println(TrappingRainWater().trappingRainWater(intArrayOf(4,2,0,3,2,5)))
}

// time complexity = O(N)
// space complexity  = O(1)