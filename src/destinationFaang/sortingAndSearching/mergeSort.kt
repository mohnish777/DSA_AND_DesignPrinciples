package destinationFaang.sortingAndSearching

// leetcode 88
// 9hrs - 7mins

fun mergeSort(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    // pointers of nums1, nums2 and end of the array
    var p1 = m - 1
    var p2 = n - 1
    var i = m + n - 1

    while (p2 >=0) {
        if (p1 >=0 && nums1[p1] > nums2[p2]) {
            nums1[i] = nums1[p1]
            p1--
        } else {
            nums1[i] = nums2[p2]
            p2--
        }
        i--
    }
    println(nums1.contentToString())
}

fun main() {
    mergeSort(nums1 = intArrayOf(1,2,3,0,0,0), m = 3, nums2 = intArrayOf(2,5,6), n = 3)
}