package destinationFaang.trees

// leet code 208
// 1 day 24 mins

class ImplementTrie {
    inner class TrieNode {
        val children = HashMap<Char, TrieNode>()
        var endOfWord: Boolean = false
    }

    val root: TrieNode = TrieNode()

    fun insert(word: String) {
        var curr = root
        for (c in word) {
            if(!curr.children.containsKey(c)) {
                curr.children[c] = TrieNode()
            }
            curr = curr.children[c]!!
        }
        curr.endOfWord = true
    }

    fun search(word: String): Boolean {
        var curr = root
        for (c in word) {
            if (!curr.children.containsKey(c)) {
               return false
            }
            curr = curr.children[c]!!
        }

        return curr.endOfWord
    }

    fun startsWith(prefix: String): Boolean {
        var curr = root
        for (c in prefix) {
            if (!curr.children.containsKey(c)) {
                return false
            }
            curr = curr.children[c]!!
        }

        return true
    }
}


/*
LeetCode 208 - Trie

TrieNode stores:
children: char -> TrieNode
endOfWord: true if a word ends here

insert:
Walk each character.
Create node if missing.
Mark last node as endOfWord.

search:
Walk each character.
If missing, return false.
At end, return endOfWord.

startsWith:
Walk each prefix character.
If missing, return false.
If all found, return true.

Time:
insert: O(L)
search: O(L)
startsWith: O(L)

L = length of word/prefix

Space:
O(total characters inserted)
* */