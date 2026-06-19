package destinationFaang.trees
// leet code 572
// 22hrs 34 mins
class SubTreeOfAnotherTree {
    inner class TreeNode(var value: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun isSameTree(s: TreeNode?, t:TreeNode?): Boolean {
        if (s == null && t == null) return true
        if (s == null || t == null || s.value != t.value) return false

        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right)
    }

    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if (subRoot == null) return true
        if (root == null) return false

        if (isSameTree(root, subRoot)) {
            return true
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot)
    }
}