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

/*
LeetCode 226 - Invert Binary Tree Complexity

n = number of nodes
h = height of tree

Time:
O(n)
Reason: visit every node once and swap children.

Space:
O(h)
Reason: recursion call stack depends on tree height.

Balanced tree:
O(log n)

Skewed tree:
O(n)
* */