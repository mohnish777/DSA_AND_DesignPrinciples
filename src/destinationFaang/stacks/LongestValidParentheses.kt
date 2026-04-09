package destinationFaang.stacks

import java.util.Stack

// Leet code 32
// 16 hrs 15 mins
class LongestValidParentheses {
    fun longestValidParentheses(s: String): Int {
        var maxLength = 0
        val stack: Stack<Int> = Stack<Int>()
        stack.push(-1) // add base for next valid substring

        for (i in 0 until s.length) {
            if (s[i] == '(') {
                // push the index of '('
                stack.push(i)
            } else {
                stack.pop()

                if (stack.isEmpty()) {
                    stack.push(i) // push current index as base
                } else {
                    maxLength = maxOf(maxLength, stack.peek())
                }
            }
        }
        return maxLength
    }
}

/*
time complexity = O(N)
space complexity = O(N)
* */