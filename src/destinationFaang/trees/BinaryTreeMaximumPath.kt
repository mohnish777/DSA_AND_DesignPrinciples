package destinationFaang.trees

// leet code - 124
// 1day - 21 mins

class BinaryTreeMaximumPath {

    inner class TreeNode(var value: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    private var result: Int = Int.MIN_VALUE

    fun maxPathSum(root: TreeNode?): Int { // maxPathValue (either left or right)
        result = root?.value ?: Int.MIN_VALUE

        fun dfs(root: TreeNode?): Int {
            if (root == null) return 0

            // nodes may have negative values, and we don't want to consider negative values
            val leftMax = maxOf(0, dfs(root.left))
            val rightMax = maxOf(0, dfs(root.right))

            result = maxOf(
                result,
                root.value + leftMax + rightMax
            ) // total path from the current node (left <- root -> right)

            return root.value + maxOf(leftMax, rightMax)
        }

        dfs(root)
        return result
    }
}

/*
LeetCode 124 - Recommended Solution

Use DFS with result variable.

dfs(node) returns:
max downward path from node without split

Why no split in return?
Parent can only continue through one side.

At each node:
leftMax = max(dfs(left), 0)
rightMax = max(dfs(right), 0)

Best path through current node:
node.val + leftMax + rightMax

Update global result with this value.

Return to parent:
node.val + max(leftMax, rightMax)

Time:
O(n)

Space:
O(h)
* */