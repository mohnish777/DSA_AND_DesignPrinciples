package destinationFaang.twoPointer

// Leet code - 11. Container With Most Water
// 6hrs
class MostWater {
    fun maxArea(height: IntArray): Int {
        var left = 0
        var right = height.size - 1
        var maxArea = 0
        while (left < right) {
            val width = right - left
            if (height[left] > height[right]){
                maxArea = maxOf(maxArea, height[right]*width)
                right--
            } else {
                maxArea = maxOf(maxArea, height[left]*width)
                left ++
            }
        }
        return maxArea
    }
}


fun main() {
    println(MostWater().maxArea(intArrayOf(1,8,6,2,5,4,8,3,7)))
}

// time complexity = O(n)
// space complexity = O(1)