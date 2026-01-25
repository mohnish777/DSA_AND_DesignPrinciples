package destinationFaang


// 128. Longest Consecutive Sequence
// 3hrs - 10 mins
fun longestConsecutive(nums: IntArray): Int {

    if (nums.isEmpty()) return 0

    val numSet = HashSet<Int>()
    for (num in nums) {
        numSet.add(num)
    }
    var longestSub = 0

    for (num in numSet) {
        if (numSet.contains(num-1)){
            continue
        } else {
            var currentNum = num
            var currentSub = 1
            while (numSet.contains(currentNum+1)){
                currentNum += 1
                currentSub++
            }
            longestSub = maxOf(longestSub, currentSub)
        }
    }
    return longestSub
}

fun main() {
    println(longestConsecutive(intArrayOf(0,3,7,2,5,8,4,6,0,1))) // 9
    println(longestConsecutive(intArrayOf(100,4,200,1,3,2))) // 4
    println(longestConsecutive(intArrayOf(1,0,1,2))) // 3
}

// time complexity = O(n) + O(n) = O(n)
// space complexity  = O(n)


// brute force approach below

fun longestConsecutive2(nums: IntArray): Int {
    var longestSub = 0

    for (i in 0 until nums.size ){
        var currentNum = nums[i]
        var currentStreak = 1

        while (true) {
            var found = false
            for (j in nums.indices) {
                if (nums[j] == currentNum+1) {
                    found = true
                    currentNum = nums[j]
                    currentStreak++
                    break
                }
            }

            if(!found) {
                break
            }
        }
        longestSub = maxOf(currentStreak, longestSub)
    }
    return longestSub
}

// time complexity = O(n^2)
//space complexity = O(1)