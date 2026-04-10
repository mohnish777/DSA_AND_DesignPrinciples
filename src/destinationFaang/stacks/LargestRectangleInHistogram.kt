package destinationFaang.stacks

import java.util.Stack
// Leet code 84
// 16hrs 35 mins

class LargestRectangleInHistogram {

    // NeetCode solution - https://www.youtube.com/watch?v=zx5Sw9130L0
    fun largestRectangleArea1(heights: IntArray) : Int {
        var maxArea = 0
        val stack: ArrayDeque<Pair<Int, Int>> = ArrayDeque() // (startIndex, Height)

        for (i in heights.indices) {
            var start = i
            while (!stack.isEmpty() && heights[stack.last().first] > heights[i]) {
                val (index, height) = stack.removeLast()
                maxArea = maxOf(maxArea, height * (i - index) )
                start = index
            }
            stack.addLast(start to heights[i])
        }

        for ( (index, height) in stack ){
            maxArea = maxOf(maxArea,height*(heights.size - index))
        }

        return maxArea
    }

    // FaangDestination
    fun largestRectangleArea2(heights: IntArray): Int {
        var maxArea = 0
        val stack: Stack<Int> = Stack<Int>()
        val n = heights.size

        for (i in 0..n) {
            val currentHeight = if (i == n) 0 else heights[i]

            while (!stack.isEmpty() && heights[stack.peek()] > currentHeight) {
                val height = heights[stack.pop()]
                val width = if (stack.isEmpty()) i else i - stack.peek() - 1
                maxArea = maxOf(maxArea, height*width)
            }
            stack.push(i)
        }

        return maxArea
    }
}

// time complexity O(N)
// space complexity O(N)