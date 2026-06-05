package destinationFaang.Queue

// Leetcode 649
// 17hrs 45 mins

class Dota2Senate {
    fun predictPartyVictory(senate: String): String {
        val d = ArrayDeque<Int>()
        val r = ArrayDeque<Int>()

        senate.forEachIndexed { idx, sen ->
            if (sen == 'R') {
                r.addLast(idx)
            } else {
                r.addLast(idx)
            }
        }

        while (r.isNotEmpty() && d.isNotEmpty()){
            val dTurn = d.removeFirst()
            val rTurn = r.removeFirst()
            if (rTurn < dTurn) {
                r.addLast(rTurn + senate.length)
            } else {
                d.addLast(dTurn + senate.length)
            }
        }

        return if (d.isEmpty()) "Radiant" else "Dire"
    }
}


/*
* time complexity
* O(N) - worst case each senate will be added one more time in the round
*
* space complexity
* O(N) - as both the queues will hold n and r and in total it's going to be n.
* */
