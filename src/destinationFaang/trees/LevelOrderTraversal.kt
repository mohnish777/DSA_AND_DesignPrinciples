package destinationFaang.trees

// leet code 102
// 21hrs 56 mins
class LevelOrderTraversal {
    inner class TreeNode(val value: Int) {
        val left: TreeNode? = null
        val right: TreeNode? = null
    }

    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val result = mutableListOf<List<Int>>()

        if (root == null)  return result

        val queue: ArrayDeque<TreeNode> = ArrayDeque<TreeNode>()
        queue.addLast(root)

        while (queue.isNotEmpty()) {
            val levelSize = queue.size
            val level: MutableList<Int> = mutableListOf<Int>()

            repeat(levelSize) {
                val node = queue.removeFirst()
                level.add(node.value)
                node.left?.let { queue.addLast(it)}
                node.right?.let {queue.addLast(it)}
            }
            result.add(level)

        }

        return result
    }

}


/*
LeetCode 102 - Binary Tree Level Order Traversal

Approach:
BFS using queue.

At each while loop:
1. Take current queue size as levelSize.
2. Process exactly levelSize nodes.
3. Add their values to current level.
4. Add their children to queue.
5. Add level to result.

Time:
O(n)
Reason: every node is visited once.

Space:
O(w)
Reason: queue stores nodes from a level.

w = maximum width of tree

Worst case space:
O(n)

Result list also takes O(n) space.
* */