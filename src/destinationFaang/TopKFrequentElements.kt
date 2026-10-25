package destinationFaang

import java.util.PriorityQueue

/*
Leetcode 347. Top K Frequent Elements - 2:19 hr
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
*/
fun TopKFrequentElements(nums: IntArray, k: Int): IntArray {
    if(nums.size == k) {
        return nums
    }

    val counts = HashMap<Int, Int>()
    for (i in 0 until nums.size) {
        if(!counts.containsKey(nums[i])) {
            counts[nums[i]] = 0
        }
        counts[nums[i]] = counts[nums[i]]!! + 1
    }

    val heap = PriorityQueue<Int> { a, b ->
        counts[a]!! - counts[b]!! // less to more - the one which is less stays on top
    }

    for (i in counts.keys) {
        heap.add(i)
        if(heap.size > k) {
            heap.poll()
        }
    }

    val ans = IntArray(k)
    for (i in ans.indices) {
        ans[i] = heap.poll()
    }
    return ans
}

/*
Let:
n = nums.size
u = number of unique numbers
- Frequency map loop: O(n) time
- Heap loop: runs u times; each add() / poll() costs O(log k)
  → O(u log k) time
- Creating answer: O(k) time
So total:
Time: O(n + u log k)
Since u ≤ n, you can also say:
Time: O(n log k)


Space:
- count map: O(u)
- Min-heap: O(k)
- Answer array: O(k)
Space: O(u + k)
Usually simplified to O(u), because k ≤ u in this problem.
* */