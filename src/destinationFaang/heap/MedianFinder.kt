package destinationFaang.heap

import java.util.PriorityQueue

// leet code 295
// 20hrs 7 mins

class MedianFinder {

    val small: PriorityQueue<Int> = PriorityQueue<Int> {a, b -> b - a} // max Heap
    val large: PriorityQueue<Int> = PriorityQueue<Int> {a, b -> a - b}

    fun addNumber(num: Int) {
        small.offer(num)

        if (small.isNotEmpty() && large.isNotEmpty() && small.peek() > large.peek()) {
            large.offer(small.poll())
        }

        if(small.size > large.size + 1) {
            large.offer(small.poll())
        }

        if (large.size > small.size + 1) {
            small.offer(large.poll())
        }

    }

    fun findMedian(): Double {
        return when {
            large.size > small.size -> large.peek().toDouble()
            small.size > large.size -> small.peek().toDouble()
            else -> (small.peek() + large.peek())/2.0
        }
    }

}

/*
*
addNum(num)
Each insertion may do a few heap operations:
offer / poll = O(log n)


Single addNum call: O(log n)
n addNum calls:     O(n log n)
findMedian call:    O(1)
space after n nums: O(n)
*
* */