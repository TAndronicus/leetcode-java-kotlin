private class E127 {
    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        val wordsLeft = HashSet(wordList)
        if (!wordsLeft.contains(endWord)) return 0
        var counter = 1
        var layer = mutableSetOf(beginWord)
        var newLayer = mutableSetOf<String>()
        while (true) {
            if (layer.isEmpty()) return 0
            for (word in layer) {
                val neighbors = findNeighbors(wordsLeft, word)
                if (neighbors.any { it == endWord }) return counter + 1
                wordsLeft.removeAll(neighbors)
                newLayer.addAll(neighbors)
            }
            layer = newLayer
            newLayer = mutableSetOf()
            counter++
        }
    }

    private fun findNeighbors(wordList: Set<String>, pattern: String): Set<String> {
        return wordList.filter { isNeighboring(it, pattern) }.toSet()
    }

    private fun isNeighboring(left: String, right: String): Boolean {
        var missed = false
        for (i in left.indices) {
            if (left[i] != right[i]) {
                if (missed) return false
                missed = true
            }
        }
        return true
    }
}


fun main() {
    val s = E127()
    println(s.ladderLength("hit", "cog", listOf("hot", "dot", "dog", "lot", "log", "cog")) == 5)
    println(s.ladderLength("hit", "cog", listOf("hot", "log", "cog")) == 0)
    println(s.ladderLength("hit", "cog", listOf("hot", "dot", "dog", "lot", "log")) == 0)
}