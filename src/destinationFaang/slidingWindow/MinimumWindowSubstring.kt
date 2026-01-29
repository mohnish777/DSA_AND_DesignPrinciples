package destinationFaang.slidingWindow

//Leet code 176
// 5hrs


fun minimumWindowSubstring(s: String, t: String): String {

    if(t.length > s.length || s.isEmpty() || t.isEmpty()) {
        return ""
    }

    val mapT = HashMap<Char,Int>()
    for (c in t) { // m
        if(!mapT.containsKey(c)) {
            mapT[c] = 0
        }
        mapT[c] = mapT[c]!! + 1
    }
    var left=0
    var right=0
    val ans  = intArrayOf(-1,0,0) // length, l, r
    var formed = 0
    val required = mapT.size
    val windowCounts = HashMap<Char, Int>()

    while (right < s.length) { //n
        val c = s[right]
        windowCounts[c] = windowCounts.getOrDefault(c,0) + 1
        if(mapT.containsKey(c) && mapT[c] == windowCounts[c]) {
            formed++
        }

        while (left <=right && formed == required){
            val ch = s[left]

            if(ans[0] == -1 || right - left +1 < ans[0]) {
                ans[0] = right -left + 1
                ans[1] = left
                ans[2] = right
            }
            windowCounts[ch] = windowCounts[ch]!! - 1
            if (mapT.containsKey(ch) && windowCounts[ch]!! < mapT[ch]!!) {
                formed--
            }
            left++
        }
        right++
    }
    return if (ans[0] == -1) "" else s.substring(ans[1], ans[2] + 1)
}

fun main(){
    println(minimumWindowSubstring("ADOBECODEBANC", "ABC"))
}

// time complexity O(n+m)
// space complexity O(n+m)