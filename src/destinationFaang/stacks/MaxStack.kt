package destinationFaang.stacks


// Leet code 716
// 12 hrs 55 mins - https://leetcode.ca/all/716.html
class MaxStack {
    private val stack: ArrayDeque<Int> = ArrayDeque<Int>()
    private val maxStack: ArrayDeque<Int> = ArrayDeque<Int>()

    fun push(x: Int) {
        val max = if(stack.isEmpty()) {
            x
        } else {
            maxOf(maxStack.last(), x)
        }
        stack.addLast(x)
        maxStack.addLast(max)
    }

    fun pop(): Int {
        maxStack.removeLast()
        return stack.removeLast()
    }

    fun top(): Int {
        return stack.last()
    }

    fun peekMax(): Int {
        return maxStack.last()
    }

    fun popMax(): Int {
        val max = peekMax()
        val buffer: ArrayDeque<Int> = ArrayDeque<Int>()

        // remove elements until we find max
        while(top() != max) {
            buffer.addLast(pop())
        }
        // remove the max element
        pop()
        while (buffer.isNotEmpty()) {
            push(buffer.removeLast())
        }

        return max
    }

}

// time complexity O(1) - entering the values
// space complexity O(1) - adding and removing the values.