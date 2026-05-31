package destinationFaang.Queue
// leet code 752
// time 17hrs 25 mins
class OpenTheLock {
    fun openTheLock(deadends: Array<String>, target: String): Int {
        if ("0000" in deadends) return -1

        fun children(lock: String): List<String> {
            val result = mutableListOf<String>()
            for (i in 0..3) {
                val digit = lock[i].digitToInt()
                result.add(lock.substring(0,i) + (digit + 1) % 10 + lock.substring(i+1))
                result.add(lock.substring(0, i) + (digit - 1 - 10) % 10 + lock.substring(i+1))
            }
            return result
        }

        val queue: ArrayDeque<Pair<String, Int>> = ArrayDeque()
        queue.add(Pair("0000", 0))
        val visit = deadends.toMutableSet()
        visit.add("0000")

        while(queue.isNotEmpty()) {
            val (lock, turns) = queue.removeFirst()
            if (lock == target) return turns

            for (child in children(lock)) {
                if(child !in visit) {
                    visit.add(child)
                    queue.add(Pair(child, turns + 1))
                }
            }
        }
        return -1
    }


    fun openTheLock2(deadends: Array<String>, target: String): Int {
        val dead = deadends.toHashSet()
        if ("0000" in dead) return -1
        if("0000" == target) return 0

        val queue: ArrayDeque<String> = ArrayDeque()
        queue.addLast("0000")
        val seen = mutableSetOf<String>()
        seen.add("0000")
        var steps = 0

        while(queue.isNotEmpty()) {
            val size = queue.size
            repeat(size) {
                val curr = queue.removeFirst()
                if (curr in dead) return@repeat
                if (curr == target) return steps
                val cs = curr.toCharArray()
                for (i in 0..3) {
                    val orig = cs[i]
                    val d = orig.digitToInt()
                    cs[i] = ('0' + (d + 1) % 10)
                    val up = String(cs)
                    if(up !in dead && seen.add(up)) queue.addLast(up)

                    cs[i] = '0' + (d -1 + 10) % 10
                    val down = String(cs)
                    if (down !in dead && seen.add(down)) queue.addLast(down)
                    cs[i] = orig
                }
            }
            steps++
        }
        return -1
    }
}

// time complexity 10^4 X 4 X 2
// 80,000 = O(1)


// space complexity
/*
O(10^4) = O(10,000) → effectively O(1)
queue holds at most 10,000 combinations
visit/seen set holds at most 10,000 combinations
*/



