package destinationFaang.heap

import java.util.PriorityQueue

// leet code 1046
// 18hrs 35 mins
class LastStoneWeight {

    fun lastStoneWeight(stones: IntArray): Int {
        val maxHeap: PriorityQueue<Int> = PriorityQueue<Int> { a, b -> b - a }

        for (stone in stones) {
            maxHeap.add(stone)
        }

        while (maxHeap.size > 1) {
            val y = maxHeap.poll()
            val x = maxHeap.poll()
            if (x!=y) maxHeap.add(y - x)
        }

        return if (maxHeap.isEmpty()) 0 else maxHeap.poll()
    }
}
/*
time complexity
for loop     → N insertions, each insert = O(log N)     → O(N log N)
while loop   → up to N-1 iterations, each poll = O(log N) → O(N log N)
Total = O(N log N)

space complexity
maxHeap stores all N stones at the start → O(N)
* */
