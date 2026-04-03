package destinationFaang.stacks


// leet code - 739
// 13hrs - 10 mins
class DailyTemperature {

    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val answer: IntArray = IntArray(temperatures.size)
        val stack: ArrayDeque<Int> = ArrayDeque<Int>()

        for (i in temperatures.indices) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.last()]) {
                val index  = stack.removeLast()
                answer[i] = i - index
            }
            stack.addLast(i)
        }

        return answer
    }
}


// time complexity = O(N)
// the while will be very small
// space complexity = O(N)