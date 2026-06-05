package destinationFaang.heap

import java.util.PriorityQueue

// leetcode 215
// 18hrs 40 mins
// solve this without sorting

class kTHLargestElementInAnArray {
    fun kTHLargestElement(nums: IntArray, k: Int): Int {
        val minHeap: PriorityQueue<Int> = PriorityQueue<Int>{ a, b -> a-b }

        for (num in nums) {
            minHeap.add(num)
            if(minHeap.size > k) {
                minHeap.poll()
            }
        }

        return minHeap.poll()
    }
}

/*
* time complexity O(N log k), k size of heap
* space complexity O(K)
* */