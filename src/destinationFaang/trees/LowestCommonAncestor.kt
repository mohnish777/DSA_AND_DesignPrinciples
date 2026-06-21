package destinationFaang.trees

// leet code 235
// 23hrs 15 mins
class LowestCommonAncestor {
    inner class TreeNode(var value: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        var curr = root

        while (curr != null) {
            if (p!!.value > curr.value && q!!.value > curr.value) {
                curr = curr.right
            } else if (p!!.value < curr.value && q!!.value < curr.value) {
                curr = curr.left
            } else {
                return curr
            }
        }

        return curr
    }
}