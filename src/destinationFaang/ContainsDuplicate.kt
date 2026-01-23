package com.example.designPrinciplesAndAlgo.freecodecamp.destinationFaang

/*
Leetcode 217 - video time 1:10 hr
Given an integer array `nums`, return `true` if any value appears at least twice in the array, and return `false`
if every element is distinct.
*/

fun containsDuplicate(nums: Array<Int>): Boolean {
    val seenNumbers = HashSet<Int>()

    for (num in nums) {
        if(num in seenNumbers) {
            return true
        }
        seenNumbers.add(num)
    }
    return false
}

// time complexity = O(n) X O(1) = O(n)
// space complexity = O(n)

