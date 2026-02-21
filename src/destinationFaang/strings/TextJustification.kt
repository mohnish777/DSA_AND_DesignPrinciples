package destinationFaang.strings


// leet code 68
class TextJustification(val list: Any) {

    fun textJustification(words: Array<String>, maxWidth: Int): List<String> {
        val res = mutableListOf<String>()
        var line = mutableListOf<String>()
        var length = 0
        var i = 0

        while (i < words.size) {
            if (length + line.size + words[i].length > maxWidth) {
                val extraSpaces = maxWidth - length
                val gap = line.size - 1
                val spaces  = extraSpaces / maxOf(1, gap)
                var remainder = extraSpaces % maxOf(1, gap)

                for (j in 0 until maxOf(1, line.size - 1)) {
                    line[j]+= " ".repeat(spaces)
                    if (remainder > 0) {
                        line[j]+=" "
                        remainder--
                    }
                }
                res.add(line.joinToString(""))
                length = 0
                line = mutableListOf()
            }

            line.add(words[i])
            length += words[i].length
            i++
        }

        // handle the last line
        val lastLine = line.joinToString(" ")
        val trailingSpace = maxWidth - lastLine.length
        res.add(lastLine + " ".repeat(trailingSpace))
        return res
    }
}

fun main() {
    val tj = TextJustification(Any())

    val words = arrayOf("This", "is", "an", "example", "of", "text", "justification.")
    val result = tj.textJustification(words, 16)

    for (line in result) {
        println("|$line|")
    }
}
