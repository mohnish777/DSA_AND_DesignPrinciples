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