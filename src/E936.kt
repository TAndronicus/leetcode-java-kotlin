private class E936 {
    fun movesToStamp(stamp: String, target: String): IntArray {
        val fullIndices = mutableListOf<Int>()
        var startIndex = 0
        while (true) {
            val index = target.indexOf(stamp, startIndex = startIndex)
            if (index == -1) break
            fullIndices.add(index)
            startIndex = index + stamp.length
        }
        val queue = ArrayDeque<Pair<String, Int>>()
        if (fullIndices.isEmpty()) queue.add(Pair(target, 0))
        else {
            var startIndex = 0
            for (index in fullIndices) {
                if (startIndex != index) queue.add(Pair(target.substring(startIndex, index), startIndex))
                startIndex = index + stamp.length
            }
        }
        val res = mutableListOf<Int>()
        while (queue.isNotEmpty()) {
            val (substring, index) = queue.removeFirst()
            val elements = getStampIndexes(substring, stamp, index)
            if (elements.isEmpty()) return intArrayOf()
            res.addAll(elements)
        }
        if (fullIndices.isNotEmpty() && fullIndices.last() + stamp.length != target.length) {
            val lastPartition = getStampIndexes(target.substring(fullIndices.last() + stamp.length), stamp, fullIndices.last() + stamp.length, target.length)
            if (lastPartition.isEmpty()) return intArrayOf()
            res.addAll(lastPartition)
        }
        res.addAll(fullIndices)
        return res.toIntArray()
    }

    private fun getStampIndexes(substring: String, stamp: String, index: Int, maxIndex: Int = Int.MAX_VALUE): List<Int> {
        val acc = ArrayDeque<Int>()
        return getStampIndexesRecursively(substring, stamp, index, acc, maxIndex)
    }

    private fun getStampIndexesRecursively(substring: String, stamp: String, index: Int, acc: ArrayDeque<Int>, maxIndex: Int): List<Int> {
        if (substring.isEmpty()) return acc.toList()
        var startIndex = 0
        while (true) {
            if (startIndex >= substring.length) break
            val charIndex = stamp.indexOf(substring.first(), startIndex = startIndex)
            if (charIndex == -1) break
            if (index - charIndex < 0) {
                startIndex = charIndex + 1
                continue
            }
            if (index - charIndex + stamp.length > maxIndex) break
            var offset = 1
            while (true) {
                if (charIndex + offset >= stamp.length || offset >= substring.length || substring[offset] != stamp[charIndex + offset]) break
                offset++
            }
            if (charIndex + offset != stamp.length) acc.addLast(index - charIndex)
            val indexes = getStampIndexesRecursively(substring.substring(offset), stamp, index + offset, acc, maxIndex)
            if (indexes.isNotEmpty()) {
                if (charIndex + offset == stamp.length) acc.addLast(index - charIndex)
                return acc.toList()
            }
            if (charIndex + offset != stamp.length) acc.removeLast()
            startIndex = charIndex + 1
        }
        return listOf()
    }
}


fun main() {
    val s = E936()
    println(s.movesToStamp("abc", "abcba").contentEquals(intArrayOf()))
    println(s.movesToStamp("abc", "abcbc").joinToString())
    println(s.movesToStamp("abca", "aabcaca").joinToString())
    println(s.movesToStamp("cab", "cabbb").joinToString())
    println(s.movesToStamp("oz", "ooozz").joinToString())
}