private class E133 {
    class Node(var `val`: Int) {
        var neighbors: ArrayList<Node?> = ArrayList<Node?>()
    }

    fun cloneGraph(node: Node?): Node? {
        if (node == null) return null
        val cache = HashMap<Int, Node>()
        val constructed = mutableSetOf<Int>()
        val queue = ArrayDeque<Node>()
        val clone = Node(node.`val`)
        queue.addLast(node)
        cache.put(node.`val`, clone)
        while (queue.isNotEmpty()) {
            val originalNode = queue.removeFirst()
            cache.get(originalNode.`val`)!!.neighbors = ArrayList(originalNode.neighbors
                .map { cache.merge(it!!.`val`, Node(it.`val`)) { existing, _ -> existing } })
            queue.addAll(originalNode.neighbors.filterNotNull().filter { !constructed.contains(it.`val`) })
            constructed.add(originalNode.`val`)
        }
        return clone
    }

    fun assertClones(nodes: Array<IntArray>): Boolean {
        val map = nodes.flatMap { it.toList() }
            .distinct()
            .map { it to Node(it) }
            .toMap()
        nodes.withIndex()
            .forEach { map.get(it.index + 1)!!.neighbors = ArrayList(it.value.map { map[it] }) }
        val clone = cloneGraph(map[1])
        return true
    }
}


fun main() {
    val s = E133()
    s.assertClones(arrayOf(intArrayOf(2, 4), intArrayOf(1, 3), intArrayOf(2, 4), intArrayOf(1, 3)))
}