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

/*
LeetCode 98 - Validate BST

Approach:
DFS with valid range.

Each node must satisfy:
leftBound < node.val < rightBound

For left child:
range becomes leftBound to node.val

For right child:
range becomes node.val to rightBound

Use Long bounds:
Long.MIN_VALUE to Long.MAX_VALUE

Reason:
TreeNode values are Int and may equal Int.MIN_VALUE or Int.MAX_VALUE.

Time:
O(n)

Space:
O(h)

Balanced:
O(log n)

Skewed:
O(n)
* */