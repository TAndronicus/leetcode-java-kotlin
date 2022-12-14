private class E97 {
    fun isInterleave(s1: String, s2: String, s3: String): Boolean {
        return if (s1.length + s2.length != s3.length) false
        else isInterleaveI(s1, s2, s3)
    }

    private fun isInterleaveI(s1: String, s2: String, s3: String): Boolean {
        return if (s3.isEmpty()) true
        else if (s1.isNotEmpty() && s1[0] == s3[0] && isInterleave(s1.substring(1), s2, s3.substring(1))) true
        else s2.isNotEmpty() && s2[0] == s3[0] && isInterleave(s1, s2.substring(1), s3.substring(1))
    }

    fun isInterleave1(s1: String, s2: String, s3: String): Boolean {
        return if (s1.length + s2.length != s3.length) false
        else isInterleave1I(s1, s2, s3)
    }

    fun isInterleave2(s1: String, s2: String, s3: String): Boolean {
        return if (s1.length + s2.length != s3.length) false
        else isInterleave2I(s1, s2, s3)
    }

    private fun isInterleave2I(s1: String, s2: String, s3: String): Boolean {
        val length = s3.length
        return if (length < 11) isInterleave1I(s1, s2, s3)
        else {
            val indexes = isInterleave2ILengths(s1, s2, s3.substring(0, length / 2))
            val indexesReversed = isInterleave2ILengths(s1.reversed(), s2.reversed(), s3.substring(length / 2).reversed())
            indexes.any { el -> indexesReversed.any { elRev -> el + elRev == s1.length } }
        }
    }

    private fun isInterleave1I(s1: String, s2: String, s3: String): Boolean {
        val lengthsQueue = ArrayDeque<IntArray>()
        val visited = mutableSetOf<IntArray>()
        lengthsQueue.addLast(intArrayOf(0, 0))
        while (lengthsQueue.isNotEmpty()) {
            val pair = lengthsQueue.removeLast()
            visited.add(pair)
            val s3length = pair.sum()
            if (s3length == s3.length) return true
            if (s1.length > pair[0] && s1[pair[0]] == s3[s3length] && !visited.contains(intArrayOf(pair[0] + 1, pair[1]))) lengthsQueue.addLast(intArrayOf(pair[0] + 1, pair[1]))
            if (s2.length > pair[1] && s2[pair[1]] == s3[s3length] && !visited.contains(intArrayOf(pair[0], pair[1] + 1))) lengthsQueue.addLast(intArrayOf(pair[0], pair[1] + 1))
        }
        return false
    }

    private fun isInterleave2ILengths(s1: String, s2: String, s3: String): List<Int> {
        val lengthsQueue = ArrayDeque<IntArray>()
        val res = mutableListOf<Int>()
        val visited = mutableSetOf<IntArray>()
        lengthsQueue.addLast(intArrayOf(0, 0))
        while (lengthsQueue.isNotEmpty()) {
            val pair = lengthsQueue.removeLast()
            visited.add(pair)
            val s3length = pair.sum()
            if (s3length == s3.length) {
                res.add(pair[0])
                continue
            }
            if (s1.length > pair[0] && s1[pair[0]] == s3[s3length] && !visited.contains(intArrayOf(pair[0] + 1, pair[1]))) lengthsQueue.addLast(intArrayOf(pair[0] + 1, pair[1]))
            if (s2.length > pair[1] && s2[pair[1]] == s3[s3length] && !visited.contains(intArrayOf(pair[0], pair[1] + 1))) lengthsQueue.addLast(intArrayOf(pair[0], pair[1] + 1))
        }
        return res
    }
}


fun main() {
    val s = E97()
    println(s.isInterleave("aabcc", "dbbca", "aadbbcbcac"))
    println(!s.isInterleave("aabcc", "dbbca", "aadbbbaccc"))
    println(s.isInterleave("", "", ""))
    println(!s.isInterleave("a", "b", "a"))
    println(s.isInterleave1("aabcc", "dbbca", "aadbbcbcac"))
    println(!s.isInterleave1("aabcc", "dbbca", "aadbbbaccc"))
    println(s.isInterleave1("", "", ""))
    println(!s.isInterleave1("a", "b", "a"))
    println(s.isInterleave2("aabcc", "dbbca", "aadbbcbcac"))
    println(!s.isInterleave2("aabcc", "dbbca", "aadbbbaccc"))
    println(s.isInterleave2("", "", ""))
    println(!s.isInterleave2("a", "b", "a"))
    println(s.isInterleave2("aabaac", "aadaaeaaf", "aadaaeaabaafaac"))
}