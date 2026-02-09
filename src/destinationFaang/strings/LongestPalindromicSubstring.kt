package destinationFaang.strings

class LongestPalindromicSubstring {
    data class PalResult(val len: Int, val strResult: String)

    fun longestPalindromeSubstring(str: String): String {
        var longestLength = 0
        var longestPalindromeSubstring = ""

        for (i in 0 until str.length) {
            val odd = checkPalindrome(str, i, i)
            if (odd.len > longestLength) {
                longestLength = odd.len
                longestPalindromeSubstring = odd.strResult
            }
            val even = checkPalindrome(str, i, i+1)
            if (even.len > longestLength) {
                longestLength  = even.len
                longestPalindromeSubstring = even.strResult
            }
        }

        return longestPalindromeSubstring
    }

    fun checkPalindrome(str: String, left: Int, right: Int): PalResult {
        var l = left
        var r = right
        println("l = $l, r = $r")
        while (l >= 0 && r < str.length && str[l] == str[r]){
            l--
            r++
        }
        // l and r are step past the palindrome i.e i value is lesser and r is more
        val start = l+1
        val end = r // we can do r -1 as well
        val len = end - start
        println("$str, start = $start, end = $end")
        val subString = str.substring(start, end)
        return PalResult(len, subString)
    }

//    fun longestPalindromeSubstring2(str: String) : String {
//        if (str.length < 2) return str
//        var l = 0
//        var r = 0
//
//        for (i in str.indices) {
//            val len1 = checkPalindrome2(str, i, i)
//            val len2 = checkPalindrome2(str, i, i+1)
//            val len = maxOf(len1, len2)
//            if (len > (r - l + 1)) {
//                l = i - (len -1)/2
//                r = i + (len/2)
//            }
//        }
//
//        return str.substring(l, r+1)
//    }
//
//    fun checkPalindrome2(str: String, left:Int, right:Int): Int {
//        var l = left
//        var r = right
//        while (l >=0 && r< str.length && str[l] == str[r]) {
//            l--
//            r++
//        }
//        // l and r are step past the palindrome i.e i value is lesser and r is more
//        val start = l+1
//        val end = r - 1
//        return end - start + 1
//    }
 }



fun main() {
    val sol = LongestPalindromicSubstring()

    val tests = listOf(
//        "babad",
//        "cbbd",
//        "a",
        "",
//        "aa",
//        "ab",
//        "abba",
//        "noon",
//        "racecar",
//        "forgeeksskeegfor",
//        "abaxyzzyxf"
    )

    for (t in tests) {
        val result = sol.longestPalindromeSubstring(t)
        println("Input: \"$t\" -> Output: \"$result\"")
    }
    println("+++++++++++++")
    for (t in tests) {
//        val result = sol.longestPalindromeSubstring2(t)
//        println("Input: \"$t\" -> Output: \"$result\"")
    }


}