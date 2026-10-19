package destinationFaang.slidingWindow

fun slidingWindowMaximum(nums: IntArray, k: Int): IntArray {
    if (nums.isEmpty() || k<=0) return intArrayOf()
    val n = nums.size
    val result = IntArray(n-k+1)
    val deque = ArrayDeque<Int>() // stores indices not the values

    for (i in 0 until n) {

        //remove indices that are outside the window
        while (deque.isNotEmpty() && deque.first()  < i -k +1) {
            deque.removeFirst()
        }

        // remove smaller values from the back
        while(deque.isNotEmpty() && nums[deque.last()] < nums[i]) {
            deque.removeLast()
        }

        deque.addLast(i)// add current index

        // window formed - so record max
        if (i > k-1) {
            result[i-k+1] = nums[deque.first()]
        }
    }

    return result
}

//solution 2
fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
    val deque = ArrayDeque<Int>() // stores indices
    val result = mutableListOf<Int>()

    for (right in nums.indices) {

        // Remove indices outside the window.
        if (deque.isNotEmpty() && deque.first() < right - k + 1) {
            deque.removeFirst()
        }

        // Remove smaller values—they cannot be future maximums.
        while (deque.isNotEmpty() && nums[deque.last()] < nums[right]) {
            deque.removeLast()
        }

        deque.addLast(right)

        // Window is now size k, so record its maximum.
        if (right >= k - 1) {
            result.add(nums[deque.first()])
        }
    }

    return result.toIntArray()
}

/*
Sliding Window Maximum Complexity

n = nums.size
k = window size

Time: O(n)

Reason:

- The for-loop runs n times.
- Each index is added to the deque exactly once:

    deque.addLast(right)

- Each index is removed from the deque at most once:
  - either from the front when it leaves the window
  - or from the back when a larger value makes it useless

- Even though there is a while-loop inside the for-loop,
  an index cannot be repeatedly removed.
  Once removed, it never enters the deque again.

So total deque add/remove operations across the entire algorithm
are at most O(n).

Result creation:
- There are (n - k + 1) windows.
- Adding each maximum is O(1).
- This is also at most O(n).

Final Time: O(n)

//space
Space: O(k) auxiliary space

Reason:

- The deque stores indices only from the current window.
- A window has at most k elements.
- Therefore deque size is at most k.

Result array:
- Contains one maximum per window.
- Size = n - k + 1.

Final space:
- Auxiliary space (excluding output): O(k)
- Including result/output: O(n)
* */