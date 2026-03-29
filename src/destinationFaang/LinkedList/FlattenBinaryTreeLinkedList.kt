package destinationFaang.LinkedList

class FlattenBinaryTreeLinkedList {

    inner class TreeNode(var value: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun flatten(root: TreeNode?): Unit {
        dfs(root)
    }

    fun dfs(root: TreeNode?): TreeNode? {

        if (root == null) return null

        val leftTail = dfs(root.left)
        val rightTail = dfs(root.right)

        if (root.left != null) {
            // Connect left tail to right subtree
            leftTail?.right = root.right

            // Move left subtree to right
            root.right = root.left
            root.left = null
        }

        return rightTail ?: leftTail ?: root
    }
}

// time complexity = O(n) Where n = number of nodes in the tree

/*
🌳 Case 1: Balanced tree
Height = log n
Space = O(log n)

🌲 Case 2: Skewed tree (like linked list)
        1
         \
          2
           \
            3
             \
              4
Height = n
Space = O(n)

✅ Final Space: O(h) -> Where h = height of tree
* */