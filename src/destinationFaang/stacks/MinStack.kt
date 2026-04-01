package destinationFaang.stacks


// leet code 155
// 12hrs 40 mins
class MinStack {

    private var head: Node? = null

    fun push(value: Int) {
        if (head == null) {
            head = Node(value, value, null)
        } else {
            head = Node(value, minOf(value, head!!.value), head)
        }
    }

    fun top(): Int {
        return head!!.value
    }

    fun pop() {
        head  = head?.next
    }

    fun getMin(): Int {
        return head!!.min
    }

    inner class Node(var value: Int, var min: Int, var next: Node?)
}

class MinStack2 {

    val stack: ArrayDeque<Pair<Int, Int>> = ArrayDeque<Pair<Int,Int>>()

    fun push(value: Int) {
        if (stack.isEmpty()) {
            stack.addLast(Pair(value, value))
        } else  {
            val min = minOf(value, stack.last().second)
            stack.addLast(Pair(value, min))
        }
    }

    fun pop() {
        stack.removeLast()
    }

    fun top(): Int {
        return stack.last().first
    }

    fun getMin(): Int {
        return stack.last().second
    }


    inner class Node(val value: Int, val min: Int, val next: Node?)
}

// time complexity O(1) for doing operations.
// space complexity O(1)