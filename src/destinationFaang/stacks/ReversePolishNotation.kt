package destinationFaang.stacks


// leet code 150
// 15hrs 35 mins
class ReversePolishNotation {

    fun evalRPN(tokens: Array<String>): Int {
        val stack = ArrayDeque<Int>()

        for (token in tokens) {
            if(isOperator(token)) {
                val b = stack.removeLast()
                val a = stack.removeLast()
                val result = applyOperator(token, a, b)
                stack.addLast(result)
            } else {
                stack.addLast(token.toInt())
            }
        }

        return stack.removeLast()
    }

    fun isOperator(token: String) : Boolean {
        return token == "+" || token == "-" || token == "*" || token == "/"
    }

    fun applyOperator(token: String, a: Int, b: Int): Int {
        return when (token) {
            "+" -> a+b
            "-" -> a-b
            "/" -> a/b
            "*" -> a*b
            else -> throw IllegalArgumentException("Unknown operator")
        }
    }
}

// time complexity = O(N)
// space complexity = O(N)