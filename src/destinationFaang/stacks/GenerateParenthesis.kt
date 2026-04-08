package destinationFaang.stacks


// Leet code 22
// 16hrs : 00 mins

class GenerateParenthesis {
    fun generateParenthesis(n: Int): List<String> {
        val ans: MutableList<String> = mutableListOf<String>()
        backTrack(ans, StringBuilder(), 0, 0, n)
        return ans
    }

    fun backTrack(
        ans: MutableList<String>,
        curr: StringBuilder,
        open: Int,
        close: Int,
        max: Int
    ) {
        if (curr.length == max*2) {
            ans.add(curr.toString())
            return
        }

        if (open < max) {
            curr.append('(')
            backTrack(ans, curr, open + 1, close, max)
            curr.deleteCharAt(curr.length - 1)
        }

        if (close < open) {
            curr.append(')')
            backTrack(ans, curr, open, close + 1, max)
            curr.deleteCharAt(curr.length - 1)
        }
    }
}

/*
notes: https://www.notion.so/Generate-Parenthesis-Leet-code-22-33cee1f83cf380719da2d4afc81df7d3?source=copy_link

* */