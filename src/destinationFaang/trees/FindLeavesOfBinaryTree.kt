package destinationFaang.trees
// Leet code 366
// 23hrs 35 mins - https://leetcode.ca/all/366.html
class FindLeavesOfBinaryTree {
    inner class TreeNode(var value: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun find(root: TreeNode?): List<List<Int>> {
        val result: MutableList<List<Int>> = mutableListOf()
        var currRoot = root

        while (currRoot != null) {
            val leaves: MutableList<Int> = mutableListOf()
            currRoot = findLeaves(currRoot, leaves)
            result.add(leaves)
        }

        return result
    }

    fun findLeaves(node: TreeNode?, leaves: MutableList<Int>): TreeNode? {
        if (node == null) return null

        if (node.left == null && node.right == null) {
            leaves.add(node.value)
            return null
        }

        node.left = findLeaves(node.left, leaves)
        node.right = findLeaves(node.right, leaves)

        return node
    }
}

class FindLeavesOfBinaryTree2 {
    inner class TreeNode(var value: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun findLeaves(root: TreeNode?): List<List<Int>> {
        val result: MutableList<MutableList<Int>> = mutableListOf()

        fun dfs(root: TreeNode?): Int {
            if (root == null) return -1

            val left = dfs(root.left)
            val right = dfs(root.right)

            val height = maxOf(left, right) + 1

            if (height == result.size) {
                result.add(mutableListOf())
            }

            result[height].add(root.value)

            return height
        }

        dfs(root)
        return result
    }
}