package destinationFaang.slidingWindow

// Leetcode - 567. Permutation in String
// 3 hrs - 45 mins
fun permutationInString(s1: String, s2: String): Boolean {
    if (s1.length > s2.length) {
        return false
    }

    val s1Map = IntArray(26)
    val s2Map = IntArray(26)

    for (i in 0 until s1.length) {
        s1Map[s1[i] - 'a']++
        s2Map[s2[i] - 'a']++
    }

    for (i in 0 until (s2.length - s1.length)) {
        if(matches(s1Map, s2Map)) {
            return true
        }
        s2Map[s2[s1.length+i]-'a']++
        s2Map[s2[i] -'a']--
    }

    return matches(s1Map,s2Map)

}

fun matches(s1Map: IntArray, s2Map: IntArray): Boolean {
    for(i in 0 until 26) {
        if(s1Map[i]!=s2Map[i]) {
            return false
        }
    }

    return true
}


fun main() {
    println(permutationInString("ab",  "eidbaooo"))
    println(permutationInString("ab",  "eidboaoo"))
}