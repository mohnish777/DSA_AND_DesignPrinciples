package destinationFaang.LinkedList

import java.util.PriorityQueue


// leet code 23
// 13 hrs 35 mins

class MergeKSortedList {

    inner class ListNode(val value: Int) {
        var next: ListNode? = null
    }

    fun mergeKList(lists: Array<ListNode?>): ListNode? {
        val minHeap: PriorityQueue<Int> = PriorityQueue<Int>()

        // Add all values in minHeap
        for (list in lists) {
            var current = list
            while (current != null) {
                minHeap.add(current.value)
                current = current.next
            }
        }

        val dummy = ListNode(0)
        var merge: ListNode? = dummy

        while (!minHeap.isNotEmpty()) {
            merge?.next = ListNode(minHeap.remove())
            merge = merge?.next
        }

        return dummy.next
    }

    /*
    🧠 Complexity Analysis
    Let:
    k = number of linked lists
    n = total number of nodes across all lists

    ⏱ Time Complexity
    Step 1: Insert all elements into heap
    minHeap.add(...)
    Each insertion = O(log n)
    Total elements = n

    👉 Cost = O(n log n)

    Remove all elements from heap
    minHeap.remove()
    Each removal = O(log n)
    Total elements = n

    👉 Cost = O(n log n)

    ✅ Total Time:
    O(n log n)

    📦 Space Complexity
    Heap stores all n elements → O(n)
    Output list → also O(n) (but usually not counted as extra)

    👉 Auxiliary space = O(n) */
}


class MergeKSortedList2 {
    inner class ListNode(val value: Int) {
        var next: ListNode? = null
    }

    fun mergeKList(lists: Array<ListNode?>): ListNode? {
        val minHeap: PriorityQueue<ListNode> = PriorityQueue<ListNode>() { a, b ->
            a.value - b.value
        }

        //Add all nodes
        for( list in lists) {
            if (list != null) {
                minHeap.add(list)
            }
        }

        val dummy = ListNode(0)
        var merge: ListNode? = dummy

        // process heap
        while (minHeap.isNotEmpty()) {
            val smallest = minHeap.poll()
            merge?.next = smallest
            merge = merge?.next

            // Add next node of extracted element
            if (smallest.next != null) {
                minHeap.add(smallest.next)
            }
        }

        return dummy.next

    }
/*
    | Approach            | Time           | Space    |
    | ------------------- | -------------- | -------- |
    | Your (value heap)   | O(n log n)     |  O(n)    | 1st solution
    | Optimal (node heap) | O(n log k)     |  O(k)    | 2nd soluton
*/
}