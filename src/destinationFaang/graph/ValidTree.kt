package destinationFaang.graph

//Leet code 261 - https://leetcode.ca/all/261.html
// 1 day 2hrs 30 mins

class ValidTree1 { // Neetcode

    fun validTree(n: Int, edges: Array<IntArray>): Boolean {
        if (n != edges.size -1) {
            return false
        }

        // no nodes - it's a valid tree
        if (n == 0) return true

        // build adj list
        val adj: MutableMap<Int, MutableList<Int>> = mutableMapOf()

        for (i in 0 until n) {
            adj[i] = mutableListOf()
        }

        for ((n1, n2) in edges) {
            adj[n1]?.add(n2)
            adj[n2]?.add(n1)
        }

        val visited: HashSet<Int> = HashSet<Int>()
        fun dfs(i: Int, prev: Int): Boolean {
            if (i in visited) return false

            visited.add(i)
            for (neighbour in adj[i]!!) {
                if (neighbour == prev) continue
                if(!dfs(neighbour, i)) return false
            }

            return true
        }

        return dfs(0, -1) && visited.size == n
    }


    /*LeetCode 261 - Graph Valid Tree Complexity

    n = number of nodes
    E = number of edges

    Why time is O(n + E):
    Building the adjacency list processes each edge once, adding it
    to two lists (undirected): O(E).
    DFS visits each node at most once — the visit check at the top
    of dfs() prevents re-entering an already-visited node — and for
    each visited node, loops through its entire neighbor list once:
    O(n + E), same reasoning as standard graph DFS.

    Time: O(n + E)

    Space: O(n + E)

    Reason:
    - adjacency list stores each edge twice (both directions): O(E)
    - visit set stores up to n entries: O(n)
    - recursion stack can go up to n deep in worst case
    (e.g. graph is one long chain)

    Key idea:
    A graph is a valid tree only if it's both fully connected (every
    node reachable from node 0) and acyclic (no node is reached twice
    except via the edge you just came from, tracked by prev). DFS
    checks both in a single traversal: hitting an already-visited
    node (that isn't prev) means a cycle exists; visit.size < n at
    the end means the graph is disconnected.*/

}

class ValidTree2 {
    fun validTree(n: Int, edges: Array<IntArray>): Boolean {

        if (n == 0) return true

        if (n != edges.size - 1) return false

        val adj: Array<MutableList<Int>> = Array(n) {
            mutableListOf<Int>()
        }

        for (edge in edges) {
            adj[edge[0]].add(edge[1])
            adj[edge[1]].add(edge[0])
        }

        val stack: ArrayDeque<Int> = ArrayDeque()
        val visited: HashSet<Int> = HashSet()

        stack.addLast(0)
        visited.add(0)

        while (stack.isNotEmpty()) {
            val node = stack.removeLast()

            for (neighbour in adj[node]) {
                if (visited.contains(neighbour)) {
                    continue
                }

                visited.add(neighbour)
                stack.addLast(node)
            }
        }

        return visited.size == n
    }

   /* LeetCode 261 - Graph Valid Tree (Iterative DFS) Complexity

    n = number of nodes
    E = number of edges

    Why time is O(n + E):
    The edges.size != n-1 check is O(1).
    Building the adjacency list processes each edge once, adding it
    to two lists: O(E).
    The stack-based traversal visits each node at most once (guarded
    by the visited check before pushing), and for each visited node,
    loops through its neighbor list once: O(n + E).

    Time: O(n + E)

    Space: O(n + E)

    Reason:
    - adjacency list stores each edge twice (both directions): O(E)
    - visited set stores up to n entries: O(n)
    - stack can hold up to n nodes in worst case: O(n)
    - no recursion stack this time (iterative), so no risk of
    stack overflow on deep/chain-shaped graphs

    Key idea:
    A connected graph with exactly n nodes and n-1 edges is guaranteed
    acyclic (graph theory fact), so checking edge count upfront rules
    out cycles without needing to track "prev" during traversal. The
    traversal then only needs to confirm full connectivity (all n
    nodes reachable from node 0).*/
}


class ValidTree3 {
    fun validTree(n: Int, edges: Array<IntArray>): Boolean {

        if (edges.size != n - 1) {
            return false
        }

        val adjacencyList = Array(n) { mutableListOf<Int>() }
        for (edge in edges) {
            adjacencyList[edge[0]].add(edge[1])
            adjacencyList[edge[1]].add(edge[0])
        }

        val visited = HashSet<Int>()

        fun dfs(node: Int) {
            visited.add(node)
            for (neighbour in adjacencyList[node]) {
                if (!visited.contains(neighbour)) {
                    dfs(neighbour)
                }
            }
        }

        dfs(0)

        return visited.size == n
    }

    /* LeetCode 261 - Graph Valid Tree (Recursive, edge-count shortcut) Complexity

    n = number of nodes
    E = number of edges

    Time: O(n + E)
    Reason: edge-count check is O(1); adjacency list build is O(E);
    DFS visits each node once and scans each node's neighbor list once: O(n + E).

    Space: O(n + E)
    Reason:
    - adjacency list stores each edge twice: O(E)
    - visited set stores up to n entries: O(n)
    - recursion stack can go up to n deep in worst case (e.g. chain graph)*/
}