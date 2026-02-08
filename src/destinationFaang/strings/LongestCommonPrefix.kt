package destinationFaang.strings

// Leetcode 14 - 7hrs :20 mins
class LongestCommonPrefix {
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) return ""
        var prefix = ""
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

}