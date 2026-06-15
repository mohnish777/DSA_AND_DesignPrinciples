package destinationFaang.trees

// leet code 104
// 21hrs 20 mins

class maxDepthOfBinaryTree {
    inner class TreeNode(val left: TreeNode? = null, val right: TreeNode? = null)

    fun maxDepth(root: TreeNode?): Int {

        if (root == null) {
            return 0
        } else {
            val leftNode = maxDepth(root.left)
            val rightNode = maxDepth(root.right)
            return maxOf(leftNode, rightNode) + 1
        }
    }
}

/*
 LeetCode 104 - Maximum Depth of Binary Tree

Approach:
Use DFS recursion.

Time Complexity:
O(n)

Reason:
Every node is visited once.

Space Complexity:
O(h)

Reason:
Recursive call stack depends on tree height.

Balanced tree:
O(log n)

Skewed tree:
O(n)

Final:
Time:  O(n)
Space: O(h)
*/