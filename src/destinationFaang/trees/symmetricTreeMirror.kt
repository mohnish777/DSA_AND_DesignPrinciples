package destinationFaang.trees

// leet code 101 problem
// 21hrs 32 mins
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

/*
LeetCode 101 - Symmetric Tree Complexity

n = number of nodes
h = height of tree

Time:
O(n)
Reason: each node is visited once.

Space:
O(h)
Reason: recursion call stack depends on tree height.

Balanced tree:
O(log n)

Skewed tree:
O(n)
* */