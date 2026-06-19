package destinationFaang.trees

import kotlin.math.max

// leet code 1448
// 22hrs 42 mins

class CountGoodNodesInBinaryTree {

    inner class TreeNode(var value: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun dfs(root: TreeNode?, maxValue: Int): Int {
        if (root == null) return 0

        var result = 0
        if (root.value >= maxValue) {
            result = 1
        }

        result += dfs(root.left, maxOf(maxValue, root.value))
        result += dfs(root.right, maxOf(maxValue, root.value))

        return result
    }

    fun goodNodes(root: TreeNode?): Int {
        if (root == null) return 0

        return dfs(root, root.value)
    }
}

/*
LeetCode 1448 - Count Good Nodes in Binary Tree

A node is good if:
node.value >= max value seen from root to that node.

Use DFS:
- Carry maxValue along the path.
- If current node >= maxValue, count it.
- Update maxValue for children.

Time:
O(n)

Reason:
Every node is visited once.

Space:
O(h)

Reason:
Recursion stack depends on tree height.

Balanced:
O(log n)

Skewed:
O(n)
* */