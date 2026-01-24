package destinationFaang

/*
Leet code 13 = 2hrs: 20 mins
* https://leetcode.com/problems/roman-to-integer/
* */
fun romanToInt(s: String): Int {

    val values: HashMap<String, Int> = hashMapOf(
        "I" to 1,
        "V" to 5,
        "X" to 10,
        "L" to 50,
        "C" to 100,
        "D" to 500,
        "M" to 1000,
        "IV" to 4,
        "IX" to 9,
        "XL" to 40,
        "XC" to 90,
        "CD" to 400,
        "CM" to 900
    )
    var i  = 0
    var sum = 0

    while (i < s.length) {
        if( i < s.length -1) {
            val twoSymbols = s.substring(i, i+2)
            if (values.containsKey(twoSymbols)) {
                sum+=values[twoSymbols]!!
                 i = i+2
                continue
            }
        }
        val oneSymbol = s.substring(i, i+1)
        sum+= values[oneSymbol]!!
        i++
    }
    return sum
}

fun main() {
    println(romanToInt("XIV"))     // 14
    println(romanToInt("MDC"))   // 1600
    println(romanToInt("MCM")     )// 1900
    println(romanToInt("MMXX"))  // 2020
    println(romanToInt("MCMXCIV"))// 1994
}

// time complexity = O(n)
// space complexity  = O(1)