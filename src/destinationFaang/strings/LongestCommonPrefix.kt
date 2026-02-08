package destinationFaang.strings

// Leetcode 14 - 7hrs :20 mins
class LongestCommonPrefix {
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) return ""
        var prefix = strs[0]
        for (i in 0 until strs.size) {
            while (!strs[i].startsWith(prefix)) {
                prefix =  prefix.substring(0, prefix.length -1)

                if (prefix.isEmpty()) return ""
            }
        }
        return prefix
    }
}


fun main() {
    val lg = LongestCommonPrefix()
    println(lg.longestCommonPrefix(arrayOf("flower", "flow", "flight")))
// Expected: "fl"

    println(lg.longestCommonPrefix(arrayOf("dog", "racecar", "car")))
// Expected: ""

    println(lg.longestCommonPrefix(arrayOf("interview", "internet", "internal")))
// Expected: "inte"

}

// time complexity  = O(N)
// space complexity = O(1)