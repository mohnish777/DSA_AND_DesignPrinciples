package destinationFaang.heap

import java.util.PriorityQueue
// leet code 621
// 17hr 42 mins
class TaskScheduler {
    fun leastInterval(tasks: CharArray, n: Int): Int {
        val freq  = IntArray(26)

        for (task in tasks) {
            freq[task-'A']++
        }

        val maxHeap: PriorityQueue<Int> = PriorityQueue<Int>{ a, b -> b - a}
        val coolDown: ArrayDeque<Pair<Int,Int>> = ArrayDeque()
        var time = 0

        for (count in freq) {
            if(count > 0) {
                maxHeap.add(count)
            }
        }

        while (maxHeap.isNotEmpty() || coolDown.isNotEmpty()) {
            time++

            if (maxHeap.isNotEmpty()) {
                val remainingCount = maxHeap.poll() - 1

                if (remainingCount > 0) {
                    coolDown.addLast(remainingCount to n + time)
                }
            }

            while (coolDown.isNotEmpty() && coolDown.first().second == time) {
                maxHeap.add(coolDown.removeFirst().first)
            }
        }
        return time
    }
}

/*
LeetCode 621 - Task Scheduler Complexity

N = total number of tasks
K = number of unique task types

For LeetCode, K <= 26.

Time:
- no of tasks: O(N)
- Heap operations: O(N log K)
- Since K <= 26, log K is constant

Final time:
O(N)

Space:
- Frequency array: O(26)
- Max heap: O(K)
- Cooldown queue: O(K)
- Since K <= 26

Final space:
O(1)

General case:
Time:  O(N log K + idleTime)
Space: O(K)
*/
