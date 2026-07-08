package destinationFaang.graph

// leet code 547
// 1day 1hr 35 mins
class NoOfProvinces {

    fun findCircleNum(isConnected: Array<IntArray>): Int {
        val n = isConnected.size
        val isVisited = BooleanArray(n)
        var provinces = 0

        fun bfs(start: Int) {
            val queue = ArrayDeque<Int>()
            queue.add(start)
            isVisited[start] = true

            while (queue.isNotEmpty()) {
                val city = queue.removeFirst()
                for (neighbours in 0 until n) {
                    if (isConnected[city][neighbours] == 1 && !isVisited[neighbours]) {
                        isVisited[neighbours] = true
                        queue.add(neighbours)
                    }
                }
            }

        }

        for (city in 0 until n) {
            if(!isVisited[city]) {
                provinces++
                bfs(city)
            }
        }

        return provinces
    }

}

class NoOfProvinces2() {
    fun findCircleNum(isConnected: Array<IntArray>): Int {
        val n = isConnected.size
        val isVisited = BooleanArray(n)
        var provinces = 0

        fun dfs(city: Int) {
            isVisited[city] = true

            for (neighbours in 0 until n) {
                if (isConnected[city][neighbours] == 1 && !isVisited[neighbours]) {
                    dfs(neighbours)
                }
            }
        }

        for (city in 0 until n) {
            if(!isVisited[city]) {
                provinces++
                dfs(city)
            }
        }

        return provinces
    }
}


/*
notes -> https://app.notion.com/p/Leet-code-547-No-of-Provinces-397ee1f83cf380bf9cf5d66b760de4d3?source=copy_link
* */