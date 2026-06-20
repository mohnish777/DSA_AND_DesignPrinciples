package destinationFaang.trees

// leet code 98
// 23hrs 1 min

class ValidBinarySearchTree {
    inner class TreeNode(var value: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun valid(root: TreeNode?, left: Long, right: Long): Boolean {
        if (root == null) return false

        val value = root.value.toLong()
        if (!(value < right && value > left)) {
            return false
        }

        return ( (valid(root.left, left, value)) && (valid(root.right, value, right)))
    }

    fun isValidBST(root: TreeNode?): Boolean {
        if (root == null) return true

        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE)
    }
}