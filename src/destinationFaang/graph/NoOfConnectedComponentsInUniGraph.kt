package destinationFaang.graph

// Leet code 323 - Premium problem - https://leetcode.ca/all/323.html
// 1 day 2hrs 23 mins.

class NoOfConnectedComponentsInUniGraph1 {

    fun countComponents(n: Int, edges: Array<IntArray>): Int {
        var counter = 0
        val visited: IntArray = IntArray(n) // [0,0,0,0,0]

        // build Adjacency
        val adjList: Array<MutableList<Int>> = Array(n) { mutableListOf<Int>()}

        for (edge in  edges) {
            adjList[edge[0]].add(edge[1])
            adjList[edge[1]].add(edge[0])
        }

        fun dfs(node: Int) {
            visited[node] = 1
            for (neighbour in adjList[node]) {
                if (visited[neighbour] == 0) {
                    dfs(neighbour)
                }
            }
        }

        for (i in 0 until n) {
            if (visited[i] == 0) {
                counter++
                dfs(i)
            }
        }

        return counter

    }

    /*
    LeetCode 323 - Number of Connected Components (DFS) Complexity

    n = number of nodes (V)
    E = number of edges

    Why time is O(V + E):
    Building the adjacency list processes each edge once but adds it
    to two lists (undirected): O(E).
    DFS visits each node exactly once (guarded by visited check) and
    traverses each edge at most twice total (once from each endpoint):
    O(V + E).

    DFS Complexity:
    Time: O(V + E)

    Space: O(V + E)

    Reason:
    - adjacency list stores each edge twice: O(E)
    - visited array stores n entries: O(V)
    - recursion stack can go up to V deep in worst case
    (e.g. graph is one long chain, or one big connected component)

    Key idea:
    Each unvisited node starts a new component. DFS marks all nodes
    reachable from it as visited, then the outer loop moves to the
    next unvisited node — each such node found starts a new component.*/

}

class NoOfConnectedComponentsInUniGraph2 {

    fun countComponents(n: Int, edges: Array<IntArray>): Int {
        val par = IntArray(n) { it }
        val rank = IntArray(n) { 0 }

        fun find(n1: Int): Int {
            var res = n1
            while (res != par[res]) {
                par[res] = par[par[res]]
                res = par[res]
            }
            return res
        }


        fun union(n1: Int, n2: Int): Int {
            val p1 = find(n1 = n1)
            val p2 = find(n1 = n2)

            if (p1 == p2) return 0

            if (rank[p2] > rank[p1]) {
                par[p1] = p2
                rank[p2] += rank[p1]
            } else {
                par[p2] = p1
                rank[p1] += rank[p2]
            }

            return 1
        }

        var res = n
        for ( (n1, n2) in edges) {
            res += union(n1, n2)
        }

        return res
    }

    /*LeetCode 323 - Number of Connected Components (Union-Find) Complexity

    n = number of nodes
    E = number of edges

    Why time is O(E · α(n)) ≈ O(E):
    Each edge triggers one union() call, which calls find() twice.
    With path compression + union by rank, each find()/union() call
    runs in amortized O(α(n)) time, where α is the inverse Ackermann
    function — grows so slowly it's effectively constant (≤ 4 for any
    n you'd ever encounter).

    Union-Find Complexity:
    Time: O(E · α(n)) — effectively O(E)

    Space: O(n)

    Reason:
    - par array stores n entries: O(n)
    - rank array stores n entries: O(n)
    - no recursion stack (find/union are iterative loops, not recursive)

    Key idea:
    Each node starts as its own group. Every union() that merges two
    different groups reduces the component count by 1. Path compression
    + union by rank keep the underlying tree nearly flat, making find()
    fast. */
}

/*
* notes: https://app.notion.com/p/LC323-Number-of-Connected-Components-3caee1f83cf38057b5c9ced47be9b077?source=copy_link
*
* */
