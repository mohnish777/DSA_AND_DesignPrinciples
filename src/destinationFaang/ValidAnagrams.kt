package com.example.designPrinciplesAndAlgo.freecodecamp.destinationFaang


/*
*Leetcode 242 Valid Anagram - 1:30 hr
Given two strings s and t, return true if t is an anagram of s, and false otherwise.
* */
fun validAnagram(s: String, t: String): Boolean {
    if(s.length != t.length) {
        return false
    }

    val charCounts = IntArray(26)

    for (i in 0 until s.length) {
        charCounts[s[i] - 'a']++
        charCounts[t[i] - 'a']--
    }

    for (count  in 0 until charCounts.size) {
        if( charCounts[count] != 0) {
            return false
        }
    }

    return true
}

// time complexity = O(n) + O(n) = O(2n) = O(n)
// space complexity = O(26)

fun main(){
    println(validAnagram("anagram", "nagaram")) // true
    println(validAnagram("rat", "car")) // false
    println(validAnagram("listen", "silent")) // true
}
