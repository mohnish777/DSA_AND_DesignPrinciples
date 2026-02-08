package destinationFaang.strings

class EncodeDecode {

    fun encode(strs: List<String>): String {
        if (strs.isEmpty()) {
            println("encode empty ${(258).toChar().toString()}")
            return (258).toChar().toString()
        }

        val sb = StringBuilder()
        val separate = (257).toChar().toString()
        for (str in strs) {
            sb.append(str)
            sb.append(separate)
        }

        sb.deleteCharAt(sb.length -1)
        return sb.toString()

    }

    fun decode(s: String): List<String>  {
        if (s == (258).toChar().toString()) {
            return emptyList()
        }

        val separate = (257).toChar().toString()
        println("decode ${s.split(separate)}")
        return s.split(separate)
    }
}


fun main() {
    val codec = EncodeDecode()

    println(codec.decode(codec.encode(listOf("Hello", "World"))))
// Expected: [Hello, World]

    println(codec.decode(codec.encode(listOf("a", "b", "c"))))
// Expected: [a, b, c]

    println(codec.decode(codec.encode(listOf("single"))))
// Expected: [single]

    println(codec.decode(codec.encode(emptyList())))
// Expected: []

    println(codec.decode(codec.encode(listOf(""))))
// Expected: [""]

    println(codec.decode(codec.encode(listOf("", ""))))
// Expected: ["", ""]

}