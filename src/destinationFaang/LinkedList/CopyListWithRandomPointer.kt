package destinationFaang.LinkedList


// Leetcode 138
// 13hrs 20 mins

class Node(
    var value: Int,
    var next: Node? = null,
    var random: Node? = null
)

class CopyListWithRandomPointer1 {

    private val visitNode: HashMap<Node, Node> = HashMap()

    fun copyRandomList(head: Node?): Node? {
        if (head == null) return null

        if (visitNode.containsKey(head)) {
            return visitNode[head]
        }

        val copy = Node(head.value)
        visitNode[head] = copy

        copy.next = copyRandomList(head.next)
        copy.random = copyRandomList(head.random)

        return copy
    }

    // time complexity = O(vertices + edges) = O(N)
    // space complexity = O(N), call stack in heap memory for "copy.next = copyRandomList(head.next)"

}

class CopyListWithRandomPointer2 {
    private fun copyRandomList(head: Node?): Node? {
        val oldToCopy: HashMap<Node?, Node?> = HashMap()
        oldToCopy[null] = null

        var curr = head
        while (curr != null) {
            val copy = Node(curr.value)
            oldToCopy[curr] = copy
            curr = curr.next
        }

        curr = head
        while (curr != null) {
            val copy = oldToCopy[curr]
            copy?.next = oldToCopy[curr.next]
            copy?.random = oldToCopy[curr.random]
            curr = curr.next
        }

        return oldToCopy[head]
    }

    // time complexity = O(N) + O(N) = O(N)
    // space complexity  = O(1)
}
