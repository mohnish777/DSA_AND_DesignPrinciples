package destinationFaang

/*
Leetcode  - 49  1:50 mins
Given an array of strings strs, group the anagrams together. You can return the answer in any order.
* */


fun groupAnagrams(str: Array<String>): List<List<String>> {

    if(str.isEmpty()) return emptyList()

    val ansMap = HashMap<String, MutableList<String>>()

    for (i in 0 until str.size) {
        val count = IntArray(26)

        for(c in str[i]) {
            count[c-'a']++
        }

        val sb = StringBuilder()
        for (i in 0 until count.size) {
            sb.append("#")
            sb.append(count[i])
        }

        val key: String = sb.toString()

        if (!ansMap.contains(key)) {
            ansMap[key] = ArrayList()
        }
        ansMap[key]!!.add(str[i])
    }

    return ArrayList(ansMap.values)
}

fun main(args: Array<String>) {
    groupAnagrams(arrayOf())

}