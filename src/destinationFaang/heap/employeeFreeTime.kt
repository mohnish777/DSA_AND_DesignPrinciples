package destinationFaang.heap

// Leet code 759 - https://leetcode.ca/all/759.html
// 19hrs 50 mins
class EmployeeFreeTime {
    inner class Interval(
        val start: Int,
        val end: Int
    )

    fun employeeFreeTime(schedule: ArrayList<ArrayList<Interval>>): ArrayList<Interval> {
        val intervals = mutableListOf<Interval>()

        for (employeeSchedule in schedule) {
            for (interval in employeeSchedule) {
                intervals.add(interval)
            }
        }

        intervals.sortBy { it.start }
        // intervals.sortWith(compareBy { it.start })

        val result: ArrayList<Interval> = arrayListOf<Interval>()
        var currentEnd: Int = intervals[0].end

        for (i in 1 until intervals.size) {
            val interval = intervals[i]

            if (interval.start > currentEnd) {
                result.add(Interval(currentEnd, interval.start))
            }

            currentEnd = maxOf(currentEnd, interval.end)
        }

        return result

    }
}


/*

* LeetCode 759 - Employee Free Time Complexity

E = number of employees
M = max number of intervals per employee
N = total number of intervals across all employees

From constraints:
1 <= E <= 50
1 <= schedule[i].size <= 50

So:
N <= 50 * 50 = 2500

Approach:
Flatten all Interval objects into one list.
Sort by start time.
Scan merged busy intervals and collect gaps.

Important:
Intervals are objects, not arrays.
Use:
interval.start
interval.end

Do not use:
interval[0]
interval[1]

Zero-length free intervals are not valid.
So only add a free interval when:
next.start > currentEnd

Not when:
next.start >= currentEnd

Time:
Flatten all intervals: O(N)
Sort intervals:        O(N log N)
Scan intervals:        O(N)

Final time:
O(N log N)

Since N <= 2500, this is efficient.

Space:
Flattened intervals list: O(N)
Result list:             O(N) worst case

Final space:
O(N)
*
* */