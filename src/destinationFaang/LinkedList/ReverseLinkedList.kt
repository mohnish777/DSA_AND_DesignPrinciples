package destinationFaang.LinkedList


// Leetcode - 206
// 11hrs 40 mins
class ReverseLinkedList {

    class ListNode(var value: Int) {
        var next: ListNode? = null
    }

    fun reverseLinkedList(head: ListNode?): ListNode?{
        var prev: ListNode? = null
        var curr = head
        while (curr != null) {
            val temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        }
        return prev
    }
}


// time complexity O(N)
// space complexity O(1)