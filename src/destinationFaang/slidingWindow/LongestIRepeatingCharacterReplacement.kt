package destinationFaang.slidingWindow


// Leetcode - 424. Longest Repeating Character Replacement
// 4hrs:00

fun characterReplacement(s: String, k: Int): Int {
    var ans = 0
    var maxOccurrence = 0
    var left  = 0
    val count = IntArray(26)

    for (right in 0 until s.length) {
        val idx = s[right] -'A'
        count[idx]++
        maxOccurrence = maxOf(maxOccurrence, count[idx])
        if (right - left + 1 - maxOccurrence > k) {
            count[s[left]-'A']--
            left++
        }
        ans = maxOf(ans, right - left +1)
    }

    return ans
}




fun main() {
    println(characterReplacement("AABABBA",1))
}


// time complexity = O(N)
// space complexity  = O(26)  = O(1)