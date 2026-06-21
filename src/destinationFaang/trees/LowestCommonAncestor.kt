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

/*
LeetCode 235 - LCA of BST

Use BST property:
left < root < right

At each node:
- If p and q are both greater, go right.
- If p and q are both smaller, go left.
- Otherwise current node is LCA.

Why otherwise?
p and q split on different sides, or current node is p/q.

Time:
O(h)

Balanced:
O(log n)

Skewed:
O(n)

Space:
O(1)

Reason:
Iterative traversal, no recursion stack.

-----------

Why O(log n) for balanced BST?

Each step moves down one level.
In a balanced BST, height = log n.

BST property lets us choose only left or right subtree.
So we ignore about half the tree each step.

Time:
O(h)

Balanced:
h = log n -> O(log n)

Skewed:
h = n -> O(n)
* */