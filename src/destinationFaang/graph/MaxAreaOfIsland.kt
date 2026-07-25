package destinationFaang.graph

// leet code 695
// 1 day 2hrs 2 mins

class MaxAreaOfIsland1 { //bfs solution
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        val rows = grid.size
        val cols = grid[0].size
        val visited: HashSet<Pair<Int, Int>> = HashSet()
        var maxArea = 0

        val directions: Array<Pair<Int,Int>> = arrayOf(
            0 to 1,
            0 to -1,
            -1 to 0,
            1 to 0
        )

        fun bfs(r: Int, c: Int) {
            var count = 0
            val q = ArrayDeque<Pair<Int, Int>>()
            q.add(r to c)
            visited.add(r to c)
            count++

            while (q.isNotEmpty()) {
                val (r, c) = q.removeFirst()

                for ((dr, dc) in directions) {
                    val nRow = r + dr
                    val nCol = c + dc
                    if (
                        nRow in 0 until rows &&
                        nCol in 0 until cols &&
                        grid[nRow][nCol] == 1 &&
                        !visited.contains(nRow to nCol)
                    ) {
                        count++
                        visited.add(nRow to nCol)
                        q.add(nRow to nCol)
                        }
                }
            }

            maxArea = maxOf(maxArea, count)
        }

        for (r in 0 until rows) {
            for (c in 0 until cols) {
                if (grid[r][c] == 1 && !visited.contains(r to c)) {
                    bfs(r, c)
                }
            }
        }

        return maxArea
    }

    /*
    No, it's not exactly "diagonal length." The tight peak is closer to min(rows, cols), not the diagonal (diagonal would be √(rows² + cols²)-ish, a different quantity). In the 3x5 example, peak was 4 ≈ min(3,5) + 1.
    But here's the real issue: you shouldn't put the tight grid-specific bound in your interview notes at all. For BFS/graph problems, the space complexity that's actually expected is O(V) — here O(rows*cols) — because:
    It's the standard answer interviewers expect for "space complexity of BFS."
    It's provably safe (each cell enqueued once, so queue ≤ total cells).
    The min(rows,cols) tighter bound only works because this graph happens to be a grid — it's not a general BFS fact, so it's not what you state.


    LeetCode 695 - Max Area of Island (BFS) Complexity
    rows, cols = dimensions of grid

    Time: O(rows * cols)
    Reason: each cell is enqueued and visited at most once.

    Space: O(rows * cols)
    Reason:
    - visited HashSet stores up to rows * cols pairs
    - queue holds at most rows * cols cells in worst case
    (each cell added once, so queue size ≤ total cells added)

    Key idea:
    Each unvisited land cell starts a new island.
    BFS explores all cells connected to that island, counting them
    and marking them visited via a HashSet.*/
}


class MaxAreaOfIsland2 { //dfs soln
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        val rows = grid.size
        val cols = grid[0].size
        var maxArea = 0
        val directions: Array<Pair<Int, Int>> = arrayOf(
            0 to 1,
            0 to -1,
            -1 to 0,
            1 to 0
        )

        fun dfs(r: Int, c: Int): Int {
            grid[r][c] = 0
            var count = 1

            for ((dr, dc) in directions) {
                val nRow = r + dr
                val nCol = c + dc
                if (
                    nRow in 0 until rows &&
                    nCol in 0 until cols &&
                    grid[nRow][nCol] == 1
                ) {
                    count += dfs(nRow, nCol)
                }
            }

            return count
        }

        for (r in 0 until rows) {
            for (c in 0 until cols) {
                if (grid[r][c] == 1) {
                    maxArea = maxOf(maxArea, dfs(r, c))
                }
            }
        }

        return maxArea
    }


    /*
    LeetCode 695 - Max Area of Island Complexity

    rows, cols = dimensions of grid

    Input:
    grid is a rows x cols matrix of 0s and 1s.

    Why time is O(rows * cols):
    DFS visits each cell at most once, since visited land cells are
    flipped from 1 to 0 immediately:

    grid[r][c] = 0

    Once flipped, a cell is never revisited or re-processed by any
    future DFS call.

    DFS Complexity:
    Time: O(rows * cols)

    Space: O(rows * cols)

    Reason:
    - no separate visited array needed: grid is mutated in place
    - recursion stack can go up to rows * cols cells in worst case
    (entire grid is one connected island)

    Key idea:
    Each unvisited land cell starts a new island.
    DFS marks all cells connected to that island as visited (by
    zeroing them out) and returns the area of that island, which
    is compared against maxArea.
    */
}