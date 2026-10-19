package destinationFaang.graph

// leet code 133
// 1 hr 3 days 21 mins

class CloneGraph {
    inner class Node(val value: Int) {
        val neighbors: ArrayList<Node?> = ArrayList()
    }

    fun cloneGraph(node: Node?): Node? {
        if (node == null) return null // leet code can pass an empty graph

        val oldToCopy: MutableMap<Node, Node> = mutableMapOf()

        fun dfs(node: Node): Node {
            if (node in oldToCopy) {
                return oldToCopy[node]!!
            }
            val copy = Node(node.value)
            oldToCopy[node] = copy

            for (neighbor in node.neighbors) {
                if(neighbor != null) {
                    copy.neighbors.add(dfs(neighbor))
                }
            }
            return copy
        }
        return dfs(node)
    }
}

/*
LeetCode 133 - Clone Graph (DFS) Complexity

V = number of nodes
E = number of edges

Why time is O(V + E):
Each node is cloned exactly once (the oldToNew check stops repeats): O(V).
For each node, the loop scans its neighbor list once, and across all nodes
that covers every edge twice (once from each endpoint): O(E).

Time: O(V + E)

Space: O(V)

Reason:
- oldToNew map stores one entry per node: O(V)
- recursion stack can go up to V deep in the worst case
  (e.g. graph is one long chain): O(V)
- the cloned graph itself is O(V + E), but that's the required output,
  so it's usually not counted as extra space
* */