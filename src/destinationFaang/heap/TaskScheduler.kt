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
T = total time intervals returned by the algorithm
  = task intervals + idle intervals

For LeetCode:
K <= 26

Counting frequencies:
O(N)

Adding counts to heap:
O(K log K)

Main while loop:
while heap is not empty OR cooldown is not empty

The loop runs T times.

Inside each iteration:
time++                       -> O(1)
maxHeap.poll()               -> O(log K)
coolDown.addLast(...)        -> O(1)
coolDown.removeFirst()       -> O(1)
maxHeap.add(...)             -> O(log K)

So each iteration is:
O(log K)

Main while loop complexity:
O(T log K)

Since K <= 26:
O(T log K) becomes O(T)

Overall time:
O(N + K log K + T log K)

For LeetCode, because K <= 26:
O(N + T)
--------------------------------
Space:
frequency array -> O(26)
max heap        -> O(K)
cooldown queue  -> O(K)

For LeetCode:
Space = O(1)

General case:
Time:  O(N + K log K + T log K)
Space: O(K)
*/
