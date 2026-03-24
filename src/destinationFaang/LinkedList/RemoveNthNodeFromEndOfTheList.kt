package destinationFaang.LinkedList


// leetcode 19
// 12 hrs 20 mins
class RemoveNthNodeFromEndOfTheList {

    class ListNode(var value: Int) {
        var next: ListNode? = null
    }

    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head
        var slow: ListNode? = dummy
        var fast: ListNode? = dummy
        for (i in 0..n) {
            fast = fast?.next
        }

        while (fast != null) {
            slow = slow?.next
            fast = fast.next
        }

        slow?.next = slow.next?.next

        return dummy.next
    }
}

// time complexity O(N)
// space complexity O(1)