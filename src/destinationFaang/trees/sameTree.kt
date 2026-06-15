package destinationFaang.trees

// leet code 104
// 21hrs 26 mins
class sameTree {
    inner class TreeNode(val value: Int) {
        val left: TreeNode? = null
        val right: TreeNode? = null
    }

    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q == null) {
            return true
        }

        if (p == null || q == null || p.value != q.value) {
            return false
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
    }
}