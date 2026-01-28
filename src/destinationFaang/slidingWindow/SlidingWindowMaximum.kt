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