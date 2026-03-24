package destinationFaang.LinkedList

// Leetcode 21
// 12hrs 11 mins
class MergeTwoSortList {
    class ListNode(val value: Int) {
        var next: ListNode? = null
    }

    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        val dummyHead = ListNode(0)
        var tail: ListNode? = dummyHead

        var l1 = list1
        var l2 = list2

        while (l1 != null && l2 !=null) {
            if (l1.value < l2.value) {
                tail?.next = ListNode(l1.value)
                l1 = l1.next
            } else {
                tail?.next = ListNode(l2.value)
                l2 = l2.next
            }

            tail = tail?.next
        }

        tail?.next = l1 ?: l2

        return dummyHead.next
    }
}

// time complexity O(N+M)
// space complexity O(1)