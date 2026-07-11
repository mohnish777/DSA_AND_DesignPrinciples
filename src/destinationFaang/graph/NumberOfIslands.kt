package destinationFaang.graph
// leet code 200
// 1 day 1 hr 50 mins

class NumberOfIslands {
    fun numIslands(grid: Array<CharArray>): Int {
        val rows = grid.size
        val cols = grid[0].size
        var islands = 0
        val directions: Array<IntArray> = arrayOf(
            intArrayOf(1, 0), //down
            intArrayOf(0, 1), //right
            intArrayOf(-1, 0), //up
            intArrayOf(0, -1) //left
        )

        fun dfs(r: Int, c: Int) {
            if (r !in 0 until rows ||
                c !in 0 until cols ||
                grid[r][c] == '0'
            ) {
                return
            }
            grid[r][c] = '0'

            for ((dr, dc) in directions) {
                dfs(r + dr, c + dc)
            }

        }


        for (r in 0 until rows) {
            for (c in 0 until cols) {
                if (grid[r][c] == '1') {
                    islands++
                    dfs(r, c)
                }
            }
        }

        return islands
    }
}

class NumberOfIslands2 {

    fun numIslands(grid: Array<CharArray>): Int {
        val rows = grid.size
        val cols = grid[0].size
        val visited: HashSet<Pair<Int, Int>> = HashSet()

        var islands = 0
        val directions: Array<Pair<Int, Int>> = arrayOf(
            1 to 0,
            0 to 1,
            -1 to 0,
            0 to -1
        )

        fun bfs(r: Int, c: Int) {
            val q = ArrayDeque<Pair<Int, Int>>()
            q.add(r to c)

            while (!q.isEmpty()) {
                val (row, col) = q.removeFirst()
                for ((dr, dc) in directions) {
                    val newRow = row + dr
                    val newCol = col + dc
                    if (
                        (newRow in 0 until rows) &&
                        (newCol in 0 until cols) &&
                        (grid[newRow][newRow] == '1') &&
                        !visited.contains(newRow to newCol)
                    ) {
                        visited.add(newRow to newCol)
                        q.addLast(newRow to newCol)

                    }
                }
            }
        }

        for (r in 0 until rows) {
            for (c in 0 until cols) {
                if (grid[r][c] == '1' && !visited.contains(r to c)) {
                    visited.add(r to c)
                    islands++
                    bfs(r, c)
                }
            }
        }
        return islands
    }
}


/*
/*
LeetCode 200 - Number of Islands Complexity

rows = number of rows
cols = number of columns

Time: O(rows * cols)

Reason:
- Scan every cell once.
- DFS marks visited land as '0',
  so each cell is visited only once.

Space: O(rows * cols)

Reason:
- No visited array is used.
- Worst-case recursion stack can contain
  all cells if the grid is one large island.

Key idea:
Each unvisited '1' starts a new island.
DFS visits all connected land.
*/
* */