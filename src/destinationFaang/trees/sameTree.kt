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

/*
*
* LeetCode 100 - Same Tree Complexity

n = number of nodes
h = height of tree

Time:
O(n)
Reason: In worst case, visit every node once.

Space:
O(h)
Reason: recursion call stack depends on tree height.

Balanced tree:
h = log n, so space = O(log n)

Skewed tree:
h = n, so space = O(n)

General answer:
Time:  O(n)
Space: O(h)
*
* */