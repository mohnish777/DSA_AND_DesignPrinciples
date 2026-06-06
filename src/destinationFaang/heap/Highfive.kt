package destinationFaang.heap

import java.util.PriorityQueue
import java.util.TreeMap

// leetcode 1086
// 19hrs 10 mins

class HighFive {
    fun highFive(items: Array<IntArray>): Array<IntArray> {
        val scores: TreeMap<Int, PriorityQueue<Int>>  = TreeMap<Int, PriorityQueue<Int>>()

        for (item in items) {
            val id = item[0]
            val score = item[1]

            if(!scores.containsKey(id)) {
                scores[id] = PriorityQueue<Int> { a, b -> b - a }
            }

            scores[id]!!.add(score)
        }

        val ans: MutableList<IntArray> = mutableListOf<IntArray>()

        for (id in scores.keys) {
            var sum = 0
            repeat(5) {
                sum += scores[id]!!.poll()
            }
            ans.add(intArrayOf(id, sum/5))
        }

        return ans.toTypedArray()
    }

}


/*
* time and space complexity notes
* https://app.notion.com/p/Leet-code-1086-377ee1f83cf380318cc2e3bff27257e5?source=copy_link
*
* */