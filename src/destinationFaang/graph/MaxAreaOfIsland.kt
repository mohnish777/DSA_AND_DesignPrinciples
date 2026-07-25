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
}