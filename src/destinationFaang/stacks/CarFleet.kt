package destinationFaang.stacks
// Leet code - 853
// 15hrs 25 mins
class CarFleet {

    fun carFleet(target: Int, positions: IntArray, speed: IntArray): Int {
        val n = positions.size
        val cars = Array(n) { DoubleArray(2)}

        // Build Cars array [position, speed]
        for (i in 0 until n) {
            cars[i][0] = positions[i].toDouble()
            cars[i][1] = (target - positions[i]).toDouble() / speed[i]
        }

        // sort by position descending
        cars.sortWith ( compareByDescending { it[0] } )
        //cars.sortWith { a, b -> (b[0] - a[0]).toInt() } - another way.

        var count = 0
        var prevTime = 0.0

        for (car in cars) {
            if (car[1] > prevTime) {
                count++
                prevTime = car[1]
            }
        }

        return count
    }
}

/*
⏱️ Time Complexity
1. Building the cars array
Loop through n elements
👉 O(n)
2. Sorting
Sorting based on position
👉 O(n log n) ← dominates
3. Traversal
Single pass through sorted array
👉 O(n)
Final = O(n log n)

space  = O(N)


* */