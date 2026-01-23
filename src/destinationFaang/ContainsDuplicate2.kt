package com.example.designPrinciplesAndAlgo.freecodecamp.destinationFaang

/*
Leet code 219 - video time 1:25 hr
Given an integer array nums and an integer k, return true if there are two
distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
*/


fun containsDuplicate2(nums: Array<Int>, k: Int) : Boolean {
    val set = HashSet<Int>()
    for (i in 0 until nums.size) {
        if (set.contains(nums[i])) {
            return true
        }
        set.add(nums[i])
        if (set.size > k) {
            set.remove(nums[i - k])
        }
    }
    return false
}

// time complexity = O(n) X O(1) = O(n)
// space complexity = O(k)
