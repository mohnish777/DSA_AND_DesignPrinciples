package destinationFaang.heap

import java.util.PriorityQueue
import kotlin.math.min

// leet code - 703
// 19hrs 20 mins

class kthLargestElementInAStream(k: Int, nums: IntArray) {
    var k: Int = 0
    val minHeap = PriorityQueue<Int> {a,b -> a-b}

    init {
        this.k = k
        for(num in nums){
            add(num)
        }
    }

    fun add(value: Int): Int {
        if (minHeap.size < k){
            minHeap.add(value)
        } else if (minHeap.peek() < value) {
            minHeap.poll()
            minHeap.add(value)
        }
        return minHeap.peek()
    }
}

/*
*
Constructor time: O(n log k)
add() time:       O(log k) worst case, O(1) if value is ignored
Space:            O(k)
* */