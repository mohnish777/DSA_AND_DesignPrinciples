package destinationFaang.trees

// Leet code 79 (solve this before leet code 212)
// nil

class WordSearch1 {

    fun exist(board: Array<CharArray>, word: String): Boolean {
        val rows = board.size
        val cols = board[0].size
        val path: HashSet<Pair<Int, Int>> = HashSet<Pair<Int, Int>>()

        fun dfs(r: Int, c: Int, i: Int): Boolean {
            if (i == word.length) return true

            if (r < 0 ||
                c < 0 ||
                r >= rows ||
                c >= cols ||
                word[i] != board[r][c] ||
                path.contains(r to c)
            ) {
                return false
            }

            path.add(r to c)
            val result  = dfs(r + 1, c, i + 1) ||
                    dfs(r - 1, c, i + 1) ||
                    dfs(r, c + 1, i + 1) ||
                    dfs(r, c - 1, i + 1)

            path.remove(r to c)
            return result
        }




        for (r in 0 until rows) {
            for (c in 0 until cols) {
                // curr row, curr, col, start of the word
                if (dfs(r, c, 0)) {
                    return true
                }
            }
        }

        return false
    }

}


/*

LeetCode 79 - Time Complexity

R = rows
C = cols
L = word length

We start DFS from every cell:
R * C

From each cell, DFS can try 4 directions:
up, down, left, right

For a word of length L:
branching can be up to 4 choices per character

So rough worst case:
4^L

Total:
O(R * C * 4^L)

Tighter idea:
Since we cannot reuse a cell, after first move we usually cannot go back.
So it can be described as:
O(R * C * 4 * 3^(L - 1))

Simple accepted answer:
Time: O(R * C * 4^L)
Space: O(L)

* */

// notes in detail - https://app.notion.com/p/Leet-code-79-Word-Search-392ee1f83cf3805a934bcd57e71fd704?source=copy_link