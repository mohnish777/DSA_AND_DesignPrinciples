package destinationFaang.trees

import kotlin.math.abs

// leet code 110
// 21hrs 47 mins
class BalancedBinaryTree {
    inner class TreeNode(val value: Int) {
        val left: TreeNode? = null
        val right: TreeNode? = null
    }

    fun dfs(root: TreeNode?): Int {
        if (root == null) return 0

        val left = dfs(root.left)
        if (left == -1) return -1

        val right = dfs(root.right)
        if (right == -1) return -1

        if (abs(left - right) > 1)  return -1

        return maxOf(left, right) + 1

    }

    fun isBalanced(root: TreeNode?): Boolean {
        return dfs(root) != -1
    }
}

/*
LeetCode 110 - Early Exit

Optimized version:
- dfs returns height if balanced.
- dfs returns -1 if unbalanced.
- If left == -1, return immediately.
- If right == -1, return immediately.

Time:
O(n) worst case

Space:
O(h)

Balanced tree:
O(log n)

Skewed tree:
O(n)
 */