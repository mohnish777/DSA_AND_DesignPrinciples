package destinationFaang.heap

import java.util.PriorityQueue
// leetcode 973
// 18hrs 50 mins

class kClosestPointToOrigin {

    fun distance(point: IntArray): Long {
        return 1L * point[0] * point[0] + 1L* point[1] * point[1]
    }

    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        val maxHeap = PriorityQueue<IntArray> { a , b ->
            distance(b).compareTo(distance(a))
        }

        for (point in points) {
            maxHeap.add(point)
            if(maxHeap.size > k) {
                maxHeap.poll()
            }
        }

        return Array(k) {
            maxHeap.poll()
        }
    }
}

/*
* time complexity
*
* offer => O(log k)
  poll  => O(log k), only when size > k
  O(2 log k), can drop constant 2

* so equivalent is O(N log(k) * m)
* equivalent to O(Nlog(k), m can be ignored it's for calculating the distance
*
*
* space complexity
* O(K)
* */