package destinationFaang.slidingWindow

// Leet code 3. Longest Substring Without Repeating Characters
// 4hrs - 20 mins

fun lengthOfLongestSubstring(s: String): Int {

    if(s.isEmpty()) return 0
    if(s.length == 1) return 1

    val set  = HashSet<Char>()
    var left = 0
    var right  = 0
    var ans = 0

    while (right < s.length) {
        val c: Char = s[right]
        while(set.contains(c)) {
            set.remove(s[left])
            left++
        }
        set.add(c)
        ans = maxOf(ans, right - left + 1)
        right++
    }

    return ans
}

fun main() {
    println(lengthOfLongestSubstring("abcabcbb"))
    println(lengthOfLongestSubstring("pwwkew"))
}

// time complexity = O(N)
// space complexity = O(1)

/*
O(min(n, m)) → effectively O(1)
Where:
    n = length of the string
    m = size of the character set
*/







