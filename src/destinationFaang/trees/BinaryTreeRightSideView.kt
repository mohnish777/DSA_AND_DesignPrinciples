package destinationFaang.trees

// leet code 199
// 22hrs 30 mins

class BinaryTreeRightSideView {
    inner class TreeNode(val value: Int) {
        val left: TreeNode? = null
        val right: TreeNode? = null
    }

    fun rightSideView(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        if (root == null) return result

        val queue = ArrayDeque<TreeNode>()
        queue.addLast(root)

        while (queue.isNotEmpty()){
            val levelSize = queue.size

            for (i in 0 until levelSize) {
                val node = queue.removeFirst()
                if (levelSize - 1 == i) {
                    result.add(node.value)
                }

                node.left?.let { queue.addLast(it)}
                node.right?.let { queue.addLast(it)}
            }
        }

        return result
    }
}

/*
LeetCode 199 - Right Side View

Use BFS level order traversal.

For each level:
- levelSize = queue.size
- Process exactly levelSize nodes
- If i == levelSize - 1, this is the last node in that level
- Add it to result

Time:
O(n)

Space:
O(w)

w = max width of tree
Worst case: O(n)

* */