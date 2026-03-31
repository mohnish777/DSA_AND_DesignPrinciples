package destinationFaang.stacks

import java.util.Stack

// Leet code 20
// 14hrs 35 mins
class ValidParentheses {

    fun isValid1(s: String): Boolean {
        val mappedBrackets: HashMap<Char,Char> = HashMap<Char, Char>()
        mappedBrackets[')'] = '('
        mappedBrackets['}'] = '{'
        mappedBrackets['}'] = '{'

        val stack: Stack<Char> = Stack<Char>()

        for(c in s) {
            if (!mappedBrackets.containsKey(c)) {
                stack.push(c)
            } else if (stack.isEmpty() || stack.pop() != mappedBrackets[c]) {
                return  false
            }
        }
        return stack.isEmpty()
    }

    fun isValid2(s: String): Boolean {
        val mappedBrackets: Map<Char, Char> = mapOf(
            ')' to '(',
            '}' to '{',
            ']' to '['
        )
        val stack: ArrayDeque<Char> = ArrayDeque<Char>()
        for (c in s) {
            if (c !in mappedBrackets) {
                stack.addLast(c)
            } else if (stack.isEmpty() || stack.removeLast() != mappedBrackets[c]) {
                return false
            }
        }

        return stack.isEmpty()
    }
}

// time complexity O(N)
// space complexity O(N)