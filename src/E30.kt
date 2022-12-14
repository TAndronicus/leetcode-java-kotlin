private class E30 {
    fun findSubstring(s: String, words: Array<String>): List<Int> {
        val wordLength = words[0].length
        if (s.length < words.size * wordLength) return listOf()
        val wordsMap = words.groupingBy { it }.eachCount()
        val res = mutableListOf<Int>()
        for (i in 0 until wordLength) {
            var currentMap = HashMap(wordsMap)
            val queue = ArrayDeque<String>()
            var counter = 0
            while ((counter + 1) * wordLength + i <= s.length) {
                val substring = s.substring(counter * wordLength + i, (counter + 1) * wordLength + i)
                if (wordsMap.contains(substring)) {
                    if (queue.size == words.size) {
                        val dequeued = queue.removeFirst()
                        currentMap.merge(dequeued, 1) { existing, _ -> minOf(existing + 1, wordsMap[dequeued]!!) }
                    }
                    queue.addLast(substring)
                    if (currentMap.contains(substring)) {
                        if (currentMap[substring] == 1) currentMap.remove(substring)
                        else currentMap[substring] = currentMap[substring]!! - 1
                        if (currentMap.isEmpty()) res.add((counter - words.size + 1) * wordLength + i)
                    } else {
                        while (true) {
                            val first = queue.removeFirst()
                            if (first == substring) break
                            currentMap.merge(first, 1) { existing, _ -> minOf(existing + 1, wordsMap[first]!!) }
                        }
                    }
                } else {
                    queue.clear()
                    currentMap = HashMap(wordsMap)
                }
                if (s.length - (counter + 1) * wordLength - i < (words.size - queue.size) * wordLength) break
                counter++
            }
        }
        return res
    }
}


fun main() {
    val s = E30()
    println(s.findSubstring("wordgoodgoodgoodbestword", arrayOf("word", "good", "best", "good")) == listOf(8))
    println(s.findSubstring("abacadaeaf", arrayOf("ac", "ad", "ae", "af", "ag")) == listOf<Int>())
    println(s.findSubstring("barfoothefoobarman", arrayOf("foo", "bar")) == listOf(0, 9))
    println(s.findSubstring("wordgoodgoodgoodbestword", arrayOf("word", "good", "best", "word")) == listOf<Int>())
    println(s.findSubstring("barfoofoobarthefoobarman", arrayOf("bar", "foo", "the")) == listOf(6, 9, 12))
    println(s.findSubstring("foobarrthebarrfoobarthe", arrayOf("foo", "the", "bar")) == listOf(14))
}