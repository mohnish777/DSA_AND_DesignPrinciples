package destinationFaang.trees

// leet code 226
// 21hrs 40 mins
class InvertTree {
    inner class TreeNode(val value: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null

    }

    fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) return null

        val temp = root.left
        root.right = root.left
        root.left = temp

        invertTree(root.left)
        invertTree(root.right)
        return root
    }
}