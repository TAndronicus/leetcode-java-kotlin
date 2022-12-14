private class E126 {
    fun findLadders1(beginWord: String, endWord: String, wordList: List<String>): List<List<String>> {
        if (!wordList.contains(endWord)) return listOf()
        val res = mutableListOf<List<String>>()
        var ladder = ArrayDeque<List<String>>()
        ladder.add(listOf(beginWord))
//        var ladder = mutableListOf(listOf(beginWord))
        var queued = ArrayDeque<List<String>>()
        while (true) {
            while (ladder.isNotEmpty()) {
                val path = ladder.removeFirst()
                val continuation = continuation(path, wordList)
                for (last in continuation) {
                    if (last == endWord) {
                        res.add(path.plus(last))
                        continue
                    }
                    queued.add(path.plus(last))
                }
            }
            if (res.isNotEmpty()) break
            if (queued.isEmpty()) return listOf()
            ladder = queued
            queued = ArrayDeque()
        }
        return res
    }

    private fun continuation(path: List<String>, wordList: List<String>): List<String> {
        return wordList.filter { !path.contains(it) && differByOne(path.last(), it) }
    }

    private fun differByOne(left: String, right: String): Boolean {
        return left.zip(right).count { it.first == it.second } == left.length - 1
    }

    val BASE: Double = 27.0
    val A_AS_INT = 96
    fun findLadders2(beginWord: String, endWord: String, wordList: List<String>): List<List<String>> {
        if (!wordList.contains(endWord)) return listOf()
        // preprocessing
        val wordMap = HashMap<Int, MutableList<String>>(beginWord.length * (wordList.size + 1))
        for (word in wordList) {
            for (hash in getHashes(word)) {
                if (!wordMap.containsKey(hash)) wordMap[hash] = mutableListOf(word)
                else wordMap[hash]!!.add(word)
            }
        }
        for (hash in getHashes(beginWord)) {
            if (!wordMap.containsKey(hash)) wordMap[hash] = mutableListOf(beginWord)
            else wordMap[hash]!!.add(beginWord)
        }
        val hashes = HashMap<String, List<Int>>(wordList.size + 1)
        wordList.forEach { hashes[it] = getHashes(it) }
        hashes[beginWord] = getHashes(beginWord)
        // computation
        val res = mutableListOf<List<String>>()
        var ladder = ArrayDeque<List<String>>()
        ladder.add(listOf(beginWord))
        var queued = ArrayDeque<List<String>>()
        while (true) {
            while (ladder.isNotEmpty()) {
                val path = ladder.removeFirst()
                val nextHashes = hashes[path.last()]!!
                for (hash in nextHashes) {
                    val nextWords = wordMap[hash]!!.filter { !path.contains(it) }
                    for (nextWord in nextWords) {
                        if (nextWord == endWord) {
                            res.add(path.plus(nextWord))
                        } else {
                            queued.add(path.plus(nextWord))
                        }
                    }
                }
            }
            if (res.isNotEmpty()) break
            if (queued.isEmpty()) return listOf()
            ladder = queued
            queued = ArrayDeque()
        }
        return res
    }

    private fun getHashes(word: String): List<Int> {
        val ints = word.withIndex()
            .map { Math.pow(BASE, it.index.toDouble()).toInt() * (it.value.code - A_AS_INT) }
        val sum = ints.sum()
        return ints.map { sum - it - 1 }
    }

    fun findLadders3(beginWord: String, endWord: String, wordList: List<String>): List<List<String>> {
        val wordsLeft = HashSet(wordList)
        if (!wordsLeft.contains(endWord)) return listOf()
        wordsLeft.remove(beginWord)
        val backtracking = mutableMapOf<String, MutableList<String>>()
        var layer = mutableSetOf(beginWord)
        var newLayer = mutableSetOf<String>()
        while (true) {
            if (layer.isEmpty()) return listOf()
            for (word in layer) {
                val neighbors = findNeighbors(wordsLeft, word)
                for (neighbor in neighbors) {
                    if (backtracking.contains(neighbor)) {
                        backtracking[neighbor]!!.add(word)
                    } else {
                        backtracking[neighbor] = mutableListOf(word)
                    }
                }
                newLayer.addAll(neighbors)
            }
            if (backtracking.contains(endWord)) break
            wordsLeft.removeAll(newLayer)
            layer = newLayer
            newLayer = mutableSetOf()
        }
        val res = mutableListOf<List<String>>()
        backtrack(backtracking, listOf(endWord), res)
        return res
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

    private fun backtrack(backtrackingMap: Map<String, List<String>>, path: List<String>, acc: MutableList<List<String>>) {
        if (backtrackingMap.contains(path.last())) {
            for (prefix in backtrackingMap[path.last()]!!) {
                backtrack(backtrackingMap, path.plus(prefix), acc)
            }
        } else {
            acc.add(path.reversed())
        }
    }
}


fun main() {
    val s = E126()
    println(s.findLadders1("hit", "cog", listOf("hot", "dot", "dog", "lot", "log", "cog")))
    println(s.findLadders1("hit", "cog", listOf("hot", "log", "cog")))
    println(s.findLadders1("hit", "cog", listOf("hot", "dot", "dog", "lot", "log")))
    println(s.findLadders2("hit", "cog", listOf("hot", "dot", "dog", "lot", "log", "cog")))
    println(s.findLadders2("hit", "cog", listOf("hot", "log", "cog")))
    println(s.findLadders2("hit", "cog", listOf("hot", "dot", "dog", "lot", "log")))
    println(
        s.findLadders2(
            "qa",
            "sq",
            listOf(
                "si",
                "go",
                "se",
                "cm",
                "so",
                "ph",
                "mt",
                "db",
                "mb",
                "sb",
                "kr",
                "ln",
                "tm",
                "le",
                "av",
                "sm",
                "ar",
                "ci",
                "ca",
                "br",
                "ti",
                "ba",
                "to",
                "ra",
                "fa",
                "yo",
                "ow",
                "sn",
                "ya",
                "cr",
                "po",
                "fe",
                "ho",
                "ma",
                "re",
                "or",
                "rn",
                "au",
                "ur",
                "rh",
                "sr",
                "tc",
                "lt",
                "lo",
                "as",
                "fr",
                "nb",
                "yb",
                "if",
                "pb",
                "ge",
                "th",
                "pm",
                "rb",
                "sh",
                "co",
                "ga",
                "li",
                "ha",
                "hz",
                "no",
                "bi",
                "di",
                "hi",
                "qa",
                "pi",
                "os",
                "uh",
                "wm",
                "an",
                "me",
                "mo",
                "na",
                "la",
                "st",
                "er",
                "sc",
                "ne",
                "mn",
                "mi",
                "am",
                "ex",
                "pt",
                "io",
                "be",
                "fm",
                "ta",
                "tb",
                "ni",
                "mr",
                "pa",
                "he",
                "lr",
                "sq",
                "ye"
            )
        )
    )
    println(s.findLadders3("hit", "cog", listOf("hot", "dot", "dog", "lot", "log", "cog")))
    println(s.findLadders3("hit", "cog", listOf("hot", "log", "cog")))
    println(s.findLadders3("hit", "cog", listOf("hot", "dot", "dog", "lot", "log")))
    println(
        s.findLadders3(
            "qa",
            "sq",
            listOf(
                "si",
                "go",
                "se",
                "cm",
                "so",
                "ph",
                "mt",
                "db",
                "mb",
                "sb",
                "kr",
                "ln",
                "tm",
                "le",
                "av",
                "sm",
                "ar",
                "ci",
                "ca",
                "br",
                "ti",
                "ba",
                "to",
                "ra",
                "fa",
                "yo",
                "ow",
                "sn",
                "ya",
                "cr",
                "po",
                "fe",
                "ho",
                "ma",
                "re",
                "or",
                "rn",
                "au",
                "ur",
                "rh",
                "sr",
                "tc",
                "lt",
                "lo",
                "as",
                "fr",
                "nb",
                "yb",
                "if",
                "pb",
                "ge",
                "th",
                "pm",
                "rb",
                "sh",
                "co",
                "ga",
                "li",
                "ha",
                "hz",
                "no",
                "bi",
                "di",
                "hi",
                "qa",
                "pi",
                "os",
                "uh",
                "wm",
                "an",
                "me",
                "mo",
                "na",
                "la",
                "st",
                "er",
                "sc",
                "ne",
                "mn",
                "mi",
                "am",
                "ex",
                "pt",
                "io",
                "be",
                "fm",
                "ta",
                "tb",
                "ni",
                "mr",
                "pa",
                "he",
                "lr",
                "sq",
                "ye"
            )
        )
    )
}