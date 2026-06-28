package destinationFaang.trees

// leet code - 124
// 1day - 21 mins

class BinaryTreeMaximumPath {

    inner class TreeNode(var value: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    private var result: Int = Int.MIN_VALUE

    fun maxPathSum(root: TreeNode?): Int { // maxPathValue (either left or right)
        result = root?.value ?: Int.MIN_VALUE

        fun dfs(root: TreeNode?): Int {
            if (root == null) return 0

            // nodes may have negative values, and we dont want to consider negative values
            val leftMax = maxOf(0, dfs(root.left))
            val rightMax = maxOf(0, dfs(root.right))

            result = maxOf(
                result,
                root.value + leftMax + rightMax
            ) // total path from the current node (left <- root -> right)

            return root.value + maxOf(leftMax, rightMax)
        }

        dfs(root)
        return result
    }
}
