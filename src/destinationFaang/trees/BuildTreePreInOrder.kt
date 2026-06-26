package destinationFaang.trees

//leet code 105
// 23hrs 45 mins

class BuildTreePreInOrder {

    inner class TreeNode(val value: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }


    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        val inorderIndex = HashMap<Int, Int>()

        for (i in inorder.indices) {
            inorderIndex[inorder[i]] = i
        }

        var preorderIndex = 0

        fun build(left: Int, right: Int): TreeNode? {
            if (left > right) return null

            val rootValue = preorder[preorderIndex]
            preorderIndex++

            val root = TreeNode(rootValue)

            val mid = inorderIndex[rootValue]!!

            root.left = build(left, mid - 1)
            root.right = build(mid + 1, right)

            return root
        }

        return build(0, inorder.lastIndex)

    }
}

/*
    Preorder:
    root -> left -> right

    So preorder[preorderIndex] is always the next root.

    Inorder:
    left -> root -> right

    So root's position in inorder splits the tree:
    left side  = left subtree
    right side = right subtree
--------

    LeetCode 105 - Build Tree from Preorder and Inorder

    Preorder:
    root -> left -> right

    Inorder:
    left -> root -> right

    Algorithm:
    1. First preorder value is root.
    2. Find root in inorder.
    3. Everything left of root in inorder is left subtree.
    4. Everything right of root in inorder is right subtree.
    5. Recursively build left and right.

    Optimization:
    Use HashMap for inorder value -> index lookup.

    Time:
    O(n)

    Reason:
    Each node is created once.
    HashMap gives O(1) lookup for root index.

    Space:
    O(n)

    Reason:
    HashMap stores n values.
    Recursion stack is O(h).

    Total:
    O(n)
* */