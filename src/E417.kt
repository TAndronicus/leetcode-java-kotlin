private class E417 {
    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
        val pacific = HashSet<List<Int>>()
        for (i in heights.indices) pacific.add(listOf(i, 0))
        for (i in heights[0].indices) pacific.add(listOf(0, i))
        val pacificQueue = ArrayDeque<List<Int>>()
        pacificQueue.addAll(pacific)
        while (pacificQueue.isNotEmpty()) {
            val indices = pacificQueue.removeFirst()
            val i = indices.first()
            val j = indices.component2()
            if (i > 0 && heights[i - 1][j] >= heights[i][j]) appendIfCanFlow(i - 1, j, pacificQueue, pacific)
            if (i < heights.size - 1 && heights[i + 1][j] >= heights[i][j]) appendIfCanFlow(i + 1, j, pacificQueue, pacific)
            if (j > 0 && heights[i][j - 1] >= heights[i][j]) appendIfCanFlow(i, j - 1, pacificQueue, pacific)
            if (j < heights[0].size - 1 && heights[i][j + 1] >= heights[i][j]) appendIfCanFlow(i, j + 1, pacificQueue, pacific)
        }
        val atlantic = HashSet<List<Int>>()
        for (i in heights.indices) atlantic.add(listOf(i, heights[0].size - 1))
        for (i in heights[0].indices) atlantic.add(listOf(heights.size - 1, i))
        val atlanticQueue = ArrayDeque<List<Int>>()
        atlanticQueue.addAll(atlantic)
        while (atlanticQueue.isNotEmpty()) {
            val indices = atlanticQueue.removeFirst()
            val i = indices.first()
            val j = indices.component2()
            if (i > 0 && heights[i - 1][j] >= heights[i][j]) appendIfCanFlow(i - 1, j, atlanticQueue, atlantic)
            if (i < heights.size - 1 && heights[i + 1][j] >= heights[i][j]) appendIfCanFlow(i + 1, j, atlanticQueue, atlantic)
            if (j > 0 && heights[i][j - 1] >= heights[i][j]) appendIfCanFlow(i, j - 1, atlanticQueue, atlantic)
            if (j < heights[0].size - 1 && heights[i][j + 1] >= heights[i][j]) appendIfCanFlow(i, j + 1, atlanticQueue, atlantic)
        }
        return pacific.intersect(atlantic).toList()
    }

    private fun appendIfCanFlow(i: Int, j: Int, queue: ArrayDeque<List<Int>>, visited: MutableSet<List<Int>>) {
        if (!visited.contains(listOf(i, j))) {
            visited.add(listOf(i, j))
            queue.add(listOf(i, j))
        }
    }
}

fun main() {
    val s = E417()
    println(
        s.pacificAtlantic(
            arrayOf(
                intArrayOf(1, 2, 2, 3, 5),
                intArrayOf(3, 2, 3, 4, 4),
                intArrayOf(2, 4, 5, 3, 1),
                intArrayOf(6, 7, 1, 4, 5),
                intArrayOf(5, 1, 1, 2, 4)
            )
        ) == listOf(listOf(0, 4), listOf(1, 3), listOf(1, 4), listOf(2, 2), listOf(3, 0), listOf(3, 1), listOf(4, 0))
    )
    println(s.pacificAtlantic(arrayOf(intArrayOf(1, 2, 2, 3, 5), intArrayOf(3, 2, 3, 4, 4), intArrayOf(2, 4, 5, 3, 1), intArrayOf(6, 7, 1, 4, 5), intArrayOf(5, 1, 1, 2, 4))))
    println(s.pacificAtlantic(arrayOf(intArrayOf(1))))
}