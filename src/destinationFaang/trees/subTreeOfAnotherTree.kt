package destinationFaang.trees
// leet code 572
// 22hrs 34 mins
class SubTreeOfAnotherTree {
    inner class TreeNode(var value: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun isSameTree(s: TreeNode?, t:TreeNode?): Boolean {
        if (s == null && t == null) return true
        if (s == null || t == null || s.value != t.value) return false

        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right)
    }

    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if (subRoot == null) return true
        if (root == null) return false

        if (isSameTree(root, subRoot)) {
            return true
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot)
    }
}

/*
LeetCode 572 - Subtree of Another Tree

Approach:
For each node in root:
- Check if tree starting there is same as subRoot.
- If not, search left and right.

isSameTree:
Checks if two trees are identical.

Time:
O(m * n)

m = nodes in root
n = nodes in subRoot

Reason:
For each root node, isSameTree may compare up to n nodes.

Space:
O(h + k)

h = height of root
k = height of subRoot

Worst case:
O(m + n)

Balanced:
O(log m + log n)


---------------
Good question. It’s O(h + k) because at some moment, you can have two recursive stacks active:

isSubtree(...) recursion stack
isSameTree(...) recursion stack

Example flow:
isSubtree(root, subRoot)
    isSubtree(root.left, subRoot)
        isSubtree(root.left.left, subRoot)
            isSameTree(someNode, subRoot)
                isSameTree(someNode.left, subRoot.left)
                    isSameTree(someNode.left.left, subRoot.left.left)

At the moment isSameTree is running, the earlier isSubtree calls are still waiting for it to finish.

So the call stack can contain:
some isSubtree calls + some isSameTree calls

That is why:
Space = O(h + k)
Where:
h = height of root
k = height of subRoot
If we only said O(h), we would be ignoring the extra recursive depth used by isSameTree.
* */