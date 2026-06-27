package destinationFaang.trees

// leet code 297
// 1 day -> 5 mins

class SerialiseDeSerialise {
    inner class TreeNode(var value: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
    fun serialize(root: TreeNode): String {
        val result: MutableList<String> = mutableListOf<String>()

        fun dfs(root: TreeNode?) {
            if (root == null) {
                result.add("N")
                return
            }
            result.add(root.value.toString())
            dfs(root.left)
            dfs(root.right)
        }

        dfs(root)
        return result.joinToString(",")

    }

    fun  deserialize(data: String): TreeNode? {
        var index = 0
        val values = data.split(",")

        fun dfs(): TreeNode? {
            if (values[index] == "N") {
                index++
                return null
            }

            val node = TreeNode(values[index].toInt())
            index++
            node.left = dfs()
            node.right = dfs()

            return node
        }

        return dfs()
    }
}

/*
LeetCode 297 - Serialize and Deserialize Binary Tree

Serialize:
Use preorder DFS:
root -> left -> right

For null:
store "N"

Deserialize:
Read values in same preorder order.
If value is "N", return null.
Otherwise, create node, then build left and right recursively.

Why null markers are needed:
They preserve exact tree shape.

Time:
O(n)

Space:
O(n)

n = number of nodes

Space reason:
Serialized list/string stores all nodes and null markers.
Recursion stack is O(h).
Overall O(n).

* */