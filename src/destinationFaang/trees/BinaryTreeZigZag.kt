package destinationFaang.trees
// leet code 103
// 22hrs 11 mins
class BinaryTreeZigZag {
    inner class TreeNode(val value: Int) {
        val left: TreeNode? = null
        val right: TreeNode? = null
    }

    fun zigZagLevelOrder(root: TreeNode?): List<List<Int>> {
        var shouldReverse = false
        val result = mutableListOf<List<Int>>()

        if (root == null) return result
        val queue = ArrayDeque<TreeNode>()
        queue.add(root)

        while (queue.isNotEmpty()) {
            val levelSize = queue.size
            val level = mutableListOf<Int>()
            repeat(levelSize) {
                val node = queue.removeFirst()
                level.add(node.value)
                node.left?.let { queue.addLast(it)}
                node.right?.let { queue.addLast(it)}
            }

            if (shouldReverse) level.reverse()
            shouldReverse  = !shouldReverse
        }
        return result
    }
}


/*
LeetCode 103 - Zigzag Level Order Complexity

n = number of nodes
w = maximum width of tree

Time:
O(n)

Reason:
Each node is processed once.
level.reverse() costs O(level size), but total reverse work across all levels is O(n).

Space:
O(w) extra space for queue.

Worst case:
O(n)

Including result output:
O(n)
* */