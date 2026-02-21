package destinationFaang.strings


// leetcode -  647

fun palindromicSubstring(str: String): Int {
    var ans  = 0
    for (i in str.indices) {
        ans += checkPalindrome(str, i, i) // for odd length strings
        ans += checkPalindrome(str, i, i + 1) // for even length strings
    }
    return ans
}

fun checkPalindrome(s: String, left: Int, right: Int):Int {
    var count = 0
    var l = left
    var r = right
    while ( l >=0 && r<s.length && s[l] == s[r]) {
        l--
        r++
        count++
    }
    return count
}

fun main() {
    println(palindromicSubstring("abba"))
    println(palindromicSubstring("aa"))
    println(palindromicSubstring("aba"))
    println(palindromicSubstring("aboba"))
}


