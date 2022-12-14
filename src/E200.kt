private class E200 {
    fun numIslands(grid: Array<CharArray>): Int {
        var numOfIslands = 0
        val queue = ArrayDeque<IntArray>()
        while (true) {
            val remaining = grid.map { it.indexOf('1') }
                .withIndex()
                .firstOrNull { it.value != -1 }
            if (remaining == null) break
            numOfIslands++
            queue.add(intArrayOf(remaining.index, remaining.value))
            while (queue.isNotEmpty()) {
                val indices = queue.removeFirst()
                grid[indices[0]][indices[1]] = '0'
                if (indices[0] > 0 && grid[indices[0] - 1][indices[1]] == '1') queue.add(intArrayOf(indices[0] - 1, indices[1]))
                if (indices[0] < grid.size - 1 && grid[indices[0] + 1][indices[1]] == '1') queue.add(intArrayOf(indices[0] + 1, indices[1]))
                if (indices[1] > 0 && grid[indices[0]][indices[1] - 1] == '1') queue.add(intArrayOf(indices[0], indices[1] - 1))
                if (indices[1] < grid[0].size - 1 && grid[indices[0]][indices[1] + 1] == '1') queue.add(intArrayOf(indices[0], indices[1] + 1))
            }
        }
        return numOfIslands
    }
}

fun main() {
    val s = E200()
    println(
        s.numIslands(
            arrayOf(
                charArrayOf('1', '1', '1', '1', '0'),
                charArrayOf('1', '1', '0', '1', '0'),
                charArrayOf('1', '1', '0', '0', '0'),
                charArrayOf('0', '0', '0', '0', '0')
            )
        ) == 1
    )
    println(
        s.numIslands(
            arrayOf(
                charArrayOf('1', '1', '0', '0', '0'),
                charArrayOf('1', '1', '0', '0', '0'),
                charArrayOf('0', '0', '1', '0', '0'),
                charArrayOf('0', '0', '0', '1', '1')
            )
        ) == 3
    )
}