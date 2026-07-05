package destinationFaang.trees

// leet code 212
// 1 day 47 mins
class WordSearch2 {

    lateinit var root: TrieNode

    inner class TrieNode {
        val children = HashMap<Char, TrieNode>()
        var word: String? = null
    }

    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
        root = TrieNode()
        for (word in words) {
            var curr = root
            for (c in word) {
                if (!curr.children.containsKey(c)){
                    curr.children[c] = TrieNode()
                }
                curr = curr.children[c]!!
            }
            curr.word = word
        }

        val rows = board.size
        val cols = board[0].size
        val result = mutableListOf<String>()

        fun dfs(r: Int, c: Int, node: TrieNode) {

            if (r < 0 ||
                c < 0 ||
                r >= rows ||
                c >= cols ||
                !node.children.containsKey(board[r][c])) {
                return
            }

            val char = board[r][c]

            if (char == '#') {
                return
            }

            board[r][c] = '#'

            val nextNode = node.children[char]!!
            if (nextNode.word != null) {
                result.add(nextNode.word as String)
                nextNode.word = null
            }

            dfs(r + 1, c, node)
            dfs(r - 1, c, node)
            dfs(r, c + 1, node)
            dfs(r, c - 1, node)

            board[r][c] = char
        }

        for (r in 0 until  rows) {
            for (c in 0 until cols) {
                dfs(r, c, root)
            }
        }

        return result
    }
}

/*
LeetCode 212 - Word Search II

Use Trie + DFS backtracking.

Trie:
Store all words.
At end node, store full word.

DFS:
Start from every board cell.
Move in 4 directions.
Mark visited cell with '#'.
Restore cell after DFS.

If trie node has word:
add it to result
set word = null to avoid duplicates.

Time:
O(R * C * 4^L) rough upper bound

Space:
O(total characters in words + L)
* */


/*
space complexity notes

LeetCode 212 - Space Complexity

W = total characters across all words
L = max word length

Total space:
O(W + L)

Why?

1. Trie space: O(W)

We insert every word into the Trie.

Example:
words = ["cat", "car", "dog"]

Total characters:
cat = 3
car = 3
dog = 3

W = 9

Trie stores characters as nodes.

cat and car share prefix:
c -> a

So shared prefixes reuse nodes.

Worst case:
If words do not share prefixes, Trie may store almost every character separately.

Therefore:
Trie space = O(W)

2. DFS/backtracking space: O(L)

During DFS, we track one active path on the board.

visited set can contain at most L cells,
because we only need to match up to the longest word length.

Recursion stack also goes at most L deep.

Therefore:
DFS space = O(L)

Final:
Trie + DFS
O(W + L)
* */