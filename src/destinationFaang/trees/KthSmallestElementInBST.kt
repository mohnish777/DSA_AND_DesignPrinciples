package destinationFaang.trees

// leet code 230
// 23hrs 22 mins

class KthSmallestElementInBST {

    inner class TreeNode(var value: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun kthSmallest(root: TreeNode?, k: Int ): Int {

        var answer = -1
        var count = 0

        fun inOrder(root: TreeNode?) {
            if(root == null) return
            if (answer != -1) return

            inOrder(root.left)
            count++
            if (count == k) {
                answer = root.value
                return
            }

            inOrder(root.right)
        }

        inOrder(root)
        return answer
    }

    fun kthSmallestIterativeWay(root: TreeNode?, k: Int): Int {
        val stack = ArrayDeque<TreeNode>()
        var count = 0
        var curr = root

        while (stack.isNotEmpty() || curr != null) {
            while (curr != null) {
                stack.addLast(curr)
                curr = curr.left
            }

            curr = stack.removeLast()
            count++
            if (count == k) {
                return curr.value
            }
            curr = curr.right
        }
        return -1
    }
}