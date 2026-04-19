package destinationFaang.Queue


// Leetcode 232
// 17 hrs, 02 mins.
class ImplementQueueUsingStack {

    private val inStack: ArrayDeque<Int> = ArrayDeque<Int>()
    private val outStack: ArrayDeque<Int> = ArrayDeque<Int>()

    fun push(x: Int) {
        inStack.addLast(x)
    }

    // Dequeue - Amortized O(1)
    fun pop(): Int {
        moveIfNeeded()
        return outStack.removeLast()
    }

    fun peek(): Int {
        moveIfNeeded()
        return outStack.last()
    }

    fun empty(): Boolean {
        return inStack.isEmpty() && outStack.isEmpty()
    }

    private fun moveIfNeeded() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.addLast(inStack.removeLast())
            }
        }
    }
}

// time complexity, worst case O(N) when we have to shift all elements to outstack
// space complexity O(N)