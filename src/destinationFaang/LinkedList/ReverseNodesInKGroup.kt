package destinationFaang.LinkedList

// leet code 25
// 13hrs 45 mins
class ReverseNodesInKGroup {
    inner class ListNode(var value: Int) {
        var next: ListNode? = null
    }

    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        if (head == null) return null
        val dummy = ListNode(0)
        dummy.next = head

        var groupPrev: ListNode? = dummy

        while (true) {
            val kth = getKth(groupPrev, k) ?: break
            var groupNext = kth.next

            var prev: ListNode? = groupNext
            var curr: ListNode? = groupPrev?.next

            while (curr != groupNext) {
                val temp = curr?.next
                curr?.next = prev
                prev = curr
                curr = temp
            }
            val temp = groupPrev?.next
            groupPrev?.next = kth
            groupPrev = temp
        }

        return dummy.next
    }

    fun getKth(current: ListNode?, k: Int): ListNode? {
        var steps = k
        var curr = current
        while (steps > 0 && curr != null) {
            curr = curr.next
            steps--
        }

        return curr
    }
}

// time complexity O(N)
// space complexity O(1)