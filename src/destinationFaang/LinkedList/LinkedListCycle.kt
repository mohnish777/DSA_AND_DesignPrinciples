package destinationFaang.LinkedList


// leet code - 141
// 12 hrs 5mins
class LinkedListCycle {
    class ListNode (val value: Int) {
        var next: ListNode? = null
    }

    fun hasCycle(head: ListNode?): Boolean {

        if (head == null) {
            return false
        }

        var slow = head
        var fast = head.next

        while (slow != null || fast!=null) {
            if (fast?.next == null) {
                return false
            }
            if (slow == fast) {
                return true
            }
            slow = slow?.next
            fast = fast.next?.next
        }

        return false
    }
}

// time complexity O(N)
// space complexity O(1)