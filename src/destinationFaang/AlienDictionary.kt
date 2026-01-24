package destinationFaang


/*

Leet code - 953. Verifying an Alien Dictionary - 2hrs 40 mins
In an alien language, surprisingly, they also use English lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.

Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographically in this alien language.
*/

fun alienDictionary(words: Array<String>, order: String): Boolean {

    val orderMap = HashMap<Char, Int>()

    for (i in 0 until order.length) {
        orderMap[order[i]] = i
    }

    for (i in 0 until words.size -1) {
        for (j in 0 until words[i].length) {
            if(j >= words[i+1].length)  {
                return false
            }
            if(words[i][j] != words[i+1][j]) {
                val currentLetter = orderMap[words[i][j]]!!
                val nextLetter = orderMap[words[i+1][j]]!!
                if (nextLetter < currentLetter) {
                    return false
                } else {
                    break
                }
            }
        }
    }

    return true
}

fun main() {
    println(alienDictionary(arrayOf("hello","leetcode"), "hlabcdefgijkmnopqrstuvwxyz"))
    println(alienDictionary(arrayOf("word","world","row"), "worldabcefghijkmnpqstuvxyz"))
    println(alienDictionary(arrayOf("apple","app"), "abcdefghijklmnopqrstuvwxyz"))
    println(alienDictionary(arrayOf("ubg","kwh"), "qcipyamwvdjtesbghlorufnkzx"))
}