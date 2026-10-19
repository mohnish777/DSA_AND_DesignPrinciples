package destinationFaang.graph

// Leet code - 684
// 1 day 3hrs 8 mins

class RedundantConnection {
    fun findRedundantConnections(edges: Array<IntArray>): IntArray {
        val n = edges.size
        val par = IntArray(n+1) { it } // nodes are 1..n, so index 0 is unused
        val rank = IntArray(n+1) { 1 }

        fun find(node: Int): Int {
            if(node != par[node]) {
                par[node] = find(par[node]) // full path compression (recursive)
            }
            return par[node]
        }

        fun union(n1: Int, n2: Int): Boolean {
            val p1 = find(n1)
            val p2 = find(n2)

            if (p1 == p2) {
                return false // already connected -> this edge makes a cycle
            }

            if (rank[p1] > rank[p2]) {
                par[p2] = p1
                rank[p1] +=rank[p2]
            } else {
                par[p1] = p2
                rank[p2] += rank[p1]
            }
            return true
        }


        for ((n1, n2) in edges) {
            if (!union(n1, n2)) {
                return intArrayOf(n1, n2)
            }
        }
        return intArrayOf()
    }
}

/*
LeetCode 684 - Redundant Connection (Union-Find) Complexity

n = number of nodes = number of edges (the input is a tree + 1 extra edge)

Why time is O(n · α(n)) ≈ O(n):
The loop runs once per edge, so n iterations. Each iteration calls
union(), which calls find() twice. With path compression + union
by rank, each find()/union() call is amortized O(α(n)), where α is
the inverse Ackermann function (effectively constant).

Time: O(n · α(n)) — effectively O(n)

Space: O(n)

Reason:
- par array stores n + 1 entries: O(n)
- rank array stores n + 1 entries: O(n)
- recursion stack inside find() is at most O(log n), because union
  by rank keeps trees shallow

Detailed exp: https://app.notion.com/p/Leet-code-684-Redundant-connection-3fdee1f83cf380208b6ed06a1afb6a2e?source=copy_link
* */