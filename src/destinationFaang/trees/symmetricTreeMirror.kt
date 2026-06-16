package destinationFaang.trees

class SymmetricTreeMirror {
    inner class TreeNode(val value: Int) {
        val left: TreeNode? = null
        val right: TreeNode? = null
    }

    fun dfs(left: TreeNode?, right: TreeNode?): Boolean {
        if (left == null && right == null) {
            return true
        }

        if ( left == null || right == null) return false

        return (left.value == right.value && dfs(left.left, right.right) && dfs(left.right, right.left))

    }

    fun isSymmetric(root: TreeNode?) : Boolean {
        return dfs(root?.left, root?.right)
    }
}