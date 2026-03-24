package destinationFaang.LinkedList

// Leet code - 876
// 11hrs  - 45 or 50 mins

class MiddleOfLinkedList {
    class ListNode(val value: Int) {
        var next: ListNode? = null
    }

    fun middleOfLinkedList(head:ListNode?): ListNode? {
        var slow: ListNode? = head
        var fast: ListNode? = head

        while (fast != null && fast.next !=null) {
            slow = slow?.next
            fast = fast.next?.next
        }

        return slow
    }
}

// time complexity = O(N)
// space complexity = O(1)