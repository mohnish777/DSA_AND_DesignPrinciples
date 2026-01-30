package destinationFaang.twoPointer

fun twoSum(numbers: IntArray, target: Int): IntArray {

        if (numbers.size == 0) {
            return intArrayOf()
        }

        var left  = 0
        var right = numbers.size - 1

        while (left< right) {
            while (numbers[left] + numbers[right] > target) {
                right--
            }
            while (numbers[left] + numbers[right] < target) {
                left++
            }
            if(numbers[left] + numbers[right] == target) {
                return intArrayOf(left+1, right+1)
            }
        }

        return intArrayOf()
}

fun main() {
    println(twoSum(intArrayOf(2,7,11,15), 9))
}