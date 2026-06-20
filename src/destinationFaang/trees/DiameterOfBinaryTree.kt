package destinationFaang.trees

// leet code 543
// 22hrs 54 mins

class DiameterOfBinaryTree {
    inner class TreeNode(var value: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun dfs(root: TreeNode?): Pair<Int, Int> { // maxHeight to maxDiameter

        if (root == null) return 0 to 0

        val left = dfs(root.left)
        val right = dfs(root.right)
        val height = 1 + maxOf(left.first, right.first)
        val diameterThroughCurrent = left.first + right.first
        val diameter = maxOf(left.second, right.second, diameterThroughCurrent)

        return height to diameter

    }

    fun diameterOfBinaryTree(root: TreeNode?): Int{
        if (root == null) return 0
        return dfs(root).second
    }
}