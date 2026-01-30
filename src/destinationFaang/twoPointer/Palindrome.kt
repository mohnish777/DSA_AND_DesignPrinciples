package destinationFaang.twoPointer

// Leet code 125
// 5hrs: 20 mins


fun isPalindrome(s: String): Boolean {

    var left  = 0
    var right = s.length -1

    while (left < right) {
        while (left < right && !s[left].isLetterOrDigit()) {
            left++
        }

        while (left < right && !s[right].isLetterOrDigit()){
            right--
        }

        if(s[left].lowercase() != s[right].lowercase()) {
            return false
        }
        left++
        right--
    }
    return true
}


fun main() {
    println(isPalindrome("A man, a plan, a canal: Panama"))
    println(isPalindrome("race a car"))
    println(isPalindrome(" "))
}

// time complexity = O(2N) = O(n)
// space complexity  = O(1)