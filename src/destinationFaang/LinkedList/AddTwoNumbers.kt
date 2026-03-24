package destinationFaang.LinkedList

class AddTwoNumbers {
    inner class ListNode (val value: Int) {
        var next: ListNode? = null
    }


    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val dummy  = ListNode(1)
        var tail: ListNode = dummy
        var carry = 0
        var list1 = l1
        var list2 = l2
        while (list1 != null || list2 != null || carry != 0) {
            val x = list1?.value ?: 0
            var y = list2?.value ?: 0
            val sum = carry + x + y

            carry = sum/10
            tail.next = ListNode(sum%10)

            if (list1 != null) {
                list1 = list1.next
            }
            if (list2 != null) {
                list2 = list2.next
            }
        }
        return dummy.next
    }
}