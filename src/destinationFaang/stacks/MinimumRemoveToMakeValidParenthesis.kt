package destinationFaang.stacks

// Leet code - 1249
// 15 hrs 45 mins

class MinimumRemoveToMakeValidParenthesis {

    fun  minRemoveToMakeValidParenthesis(s: String): String {
        val removeIndices: MutableSet<Int> = mutableSetOf<Int>()
        val stack: ArrayDeque<Int> = ArrayDeque()

        for (i in s.indices) {
            val c = s[i]
            if (c == '(') {
                stack.addLast(i)
            } else if (c == ')') {
                if(stack.isEmpty()) {
                    removeIndices.add(i)
                } else {
                    stack.removeLast()
                }
            }
        }

        // Add remaining un matched "(" in removeIndices
        while (!stack.isEmpty()) {
            removeIndices.add(stack.removeLast())
        }

        // Build Result
        val result = StringBuilder()
        for (i in s.indices) {
            if (i !in removeIndices) {
                result.append(s[i])
            }
        }

        return result.toString()
    }

}

// time complexity = O(N) + O(N) + O(N) = O(N)
/*
space complexity

Worst case: all invalid
👉 O(N)
Result StringBuilder
Up to size N
👉 O(N)

= O(N)
 */

