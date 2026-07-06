package destinationFaang.trees

// leet code 211
// 1 day 1hr 4 mins
class WordDictionary {

    var root: TrieNode

    inner class TrieNode {
        val children = HashMap<Char, TrieNode>()
        var isWord = false
    }

    init {
        root = TrieNode()
    }

    fun addWord(word: String) {
        var curr = root
        for ( c in word) {
            if(!curr.children.containsKey(c)) {
                curr.children[c] = TrieNode()
            }
            curr = curr.children[c]!!
        }
        curr.isWord = true
    }

    fun searchWord(word: String): Boolean {

        fun dfs(j: Int, root: TrieNode): Boolean {
            var curr = root
            for (i in j until word.length) {
                val c = word[i]
                if (c == '.') {
                    for (child in curr.children.values) {
                        if(dfs(i + 1,child )) {
                            return true
                        }
                    }
                    return false

                } else {
                    if(!curr.children.containsKey(c)) {
                        return false
                    }
                    curr = curr.children[c]!!
                }
            }
            return curr.isWord
        }

        return dfs(0, root)

    }

}

/*
LeetCode 211 - Word Dictionary

Use Trie.

addWord:
Same as normal Trie insert.

search:
Use DFS because '.' can match any character.

If current char is normal:
move to that child if it exists.

If current char is '.':
try all children.
If any child path returns true, return true.

At the end:
return curr.word
to make sure a full word ends here.

Time:
addWord: O(L)

search:
Without dots: O(L)
With dots: can branch.
Worst case: O(26^L)

Space:
Trie storage: O(total characters inserted)
DFS recursion: O(L)
* */