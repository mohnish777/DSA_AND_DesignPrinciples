package destinationFaang.sortingAndSearching

import kotlin.math.ceil

class KoKoEatingBananas {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        var left = 1
        var right = 1
        for (pile in piles) {
            right = maxOf(right, pile)
        }


        while (left < right) {
            val mid = left + (right - left) / 2
            if (canFinish(piles, mid, h)) {
                right = mid
            } else {
                left = mid + 1
            }
        }
        return left
    }

    fun canFinish(piles: IntArray, mid: Int, h: Int): Boolean {
        var count = 0
        for (pile in piles) {
            count += ceil(pile.toDouble() / mid).toInt()
        }
        return count <= h
    }
}

fun main() {
    val solution = KoKoEatingBananas()

    val testCases = listOf(
        Pair(intArrayOf(3, 6, 7, 11), 8),          // expected = 4
        Pair(intArrayOf(30), 5),                   // expected = 6
        Pair(intArrayOf(30, 11, 23, 4, 20), 5),     // expected = 30
        Pair(intArrayOf(30, 11, 23, 4, 20), 6),     // expected = 23
        Pair(intArrayOf(1, 1, 1, 1, 1, 1, 1), 7),   // expected = 1
        Pair(intArrayOf(5, 8, 6), 3),               // expected = 8
        Pair(intArrayOf(9, 8, 7, 6, 5), 10),        // expected = 5
        Pair(intArrayOf(1_000_000_000, 1_000_000_000, 1_000_000_000), 3) // expected = 1_000_000_000
    )

    for ((piles, h) in testCases) {
        val result = solution.minEatingSpeed(piles, h)
        println("piles=${piles.contentToString()}, h=$h → minSpeed=$result")
    }
}

/* time complexity
* no of piles N
* max number M
* binary search between 1 to M
* so log(M)
* in each binary search we are iterating again that's N times
* so time complexity O(N log M)
* */


/*
* space complexity
* O(1)
* */