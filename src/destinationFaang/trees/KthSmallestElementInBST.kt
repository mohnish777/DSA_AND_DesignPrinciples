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

/*
LeetCode 230 - Kth Smallest in BST Complexity

Both iterative and recursive inorder:

n = number of nodes
h = height of tree
k = kth smallest position

Why inorder?
BST inorder traversal gives sorted order:
left -> root -> right

Time:
O(h + k)

Reason:
First go down the left path: O(h)
Then visit nodes until kth smallest: O(k)

Worst case:
O(n)

When k = n, may visit all nodes.

Balanced BST:
O(log n + k)

Skewed BST:
O(n)

Space:
O(h)

Reason:
Iterative uses explicit stack.
Recursive uses call stack.

Balanced:
O(log n)

Skewed:
O(n)

*/