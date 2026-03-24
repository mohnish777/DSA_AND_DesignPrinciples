package destinationFaang.sortingAndSearching


// merge sort

// Leet code - 148
// 10hrs 10 mins

class ListNode(var value: Int) {
    var next: ListNode? = null
}

class SortLinkedList {

    fun sortList(head: ListNode?): ListNode? {
        // base case
        if (head == null || head.next == null) return head

        // split the list into 2 halves
        val mid: ListNode? = getMid(head)
        val left = sortList(head)
        val right = sortList(mid)

        return merge(left, right)
    }

    fun getMid(head: ListNode): ListNode? {
        var prev: ListNode? = null
        var slow: ListNode? = head
        var fast: ListNode? = head
        while (fast != null && fast.next != null) { // condition for if list contains 1 or 2 values
            prev = slow
            slow = slow?.next
            fast = fast.next?.next
        }
        val mid = slow
        prev?.next = null
        return mid
    }

    fun merge(left: ListNode?, right: ListNode?): ListNode {
        val dummy = ListNode(0)
        var tail = dummy

        var list1 = left
        var list2 = right

        while (list1 != null && list2 != null) {
            if (list1.value < list2.value) {
                tail.next = list1
                list1 = list1.next
            } else {
                tail.next = list2
                list2 = list2.next
            }
            tail = tail.next!!
        }

        tail.next = list1 ?: list2
        return dummy.next!!
    }


    fun buildList(vararg values: Int): ListNode? {
        if (values.isEmpty()) return null
        val head = ListNode(values[0])
        var curr = head
        for (i in 1 until values.size) {
            curr.next = ListNode(values[i])
            curr = curr.next!!
        }
        return head
    }

    fun printList(head: ListNode?) {
        val sb = StringBuilder()
        var curr = head
        while (curr !=null) {
            sb.append(curr.value)
            if (curr.next != null) sb.append("->")
            curr = curr.next
        }

        sb.append("->null")
        println(sb.toString())
    }
}


fun main() {
    val sol = SortLinkedList()

    val tests =  listOf<ListNode?>(
        sol.buildList(4, 2, 1, 3),
        sol.buildList(8, 7, 1, 2, 3, 4, 5, 6),
        sol.buildList(5, 4, 3, 2, 1),
        sol.buildList(1, 2, 3, 4, 5),
        sol.buildList(1),
        sol.buildList(),
        sol.buildList(2, 2, 1, 3, 3, 0),
        sol.buildList(-1, 5, 3, 4, 0)
    )

    for ((i, test) in tests.withIndex()) {
        println("Test ${i+1}")
        println("Before: ")
        sol.printList(test)

        println("After: ")
        val sorted = sol.sortList(test)
        sol.printList(sorted)
        println("---------------")
    }
}

// time complexity O(N log N)
// space complexity O(log N)