package destinationFaang.Queue

class ImplementStackUsingQueue {
    var q1: ArrayDeque<Int> = ArrayDeque<Int>()
    var q2: ArrayDeque<Int> = ArrayDeque<Int>()

    fun push(x: Int) {
        q2.addLast(x)

        while (!q1.isEmpty()) {
            q2.addLast(q1.removeFirst())
        }

        val temp = q1
        q1 = q2
        q2 = temp
    }

    fun pop(): Int {
        return q1.removeFirst()
    }

    fun top(): Int {
        return q1.first()
    }

    fun empty(): Boolean {
        return  q1.isEmpty()
    }
}

/*
*
* 🔥 Final truth -  time complexity
Operation	       Complexity
Single             push	O(N) - worst case for single push
N pushes total	   O(N²) - worst case for total pushes
*
* */

// space complexity = O(N)