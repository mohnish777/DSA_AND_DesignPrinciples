package destinationFaang.LinkedList


// Leet code 143
// 12 hrs 45 mins

class ReOrderList {
    inner class ListNode (val value: Int) {
        var next: ListNode? = null
    }

    fun reOrderList(head: ListNode?): ListNode? {
        val midNode: ListNode? = findMidNode(head)
        var second: ListNode? = reverseLinkedList(midNode)

        var first: ListNode? = head
        while (second?.next != null) {
            val temp1: ListNode? = first?.next
            val temp2: ListNode? = second.next

            head?.next = second
            second.next = temp1
            first = temp1
            second = temp2
        }
        return head
    }

    fun reverseLinkedList(midNode: ListNode?): ListNode? {
        var prev: ListNode? = null
        var curr: ListNode? = midNode
        while(curr != null) {
            val temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        }
        return prev
    }

    fun findMidNode(head: ListNode?): ListNode? {
        var slow: ListNode? = head
        var fast: ListNode? = head

        while (fast != null && fast.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }
        return slow
    }
}
/*
time complexity
find mid = O(N)
reverse list = O(N/2)
merge list = O(N)
total = O(N)

space complexity O(1)
*/
