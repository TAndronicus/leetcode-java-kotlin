private class E336 {
    fun palindromePairs(words: Array<String>): List<List<Int>> {
        val wordMap = HashMap<String, Int>()
        val palindromes = mutableSetOf<Int>()
        val empty = mutableSetOf<Int>()
        val res = mutableSetOf<List<Int>>()
        for (indexedWord in words.withIndex()) {
            if (indexedWord.value.isNotEmpty()) {
                wordMap[indexedWord.value] = indexedWord.index
                if (isPalindrome(indexedWord.value)) palindromes.add(indexedWord.index)
            } else empty.add(indexedWord.index)
        }
        for ((word, index) in wordMap.entries) {
            val reversed = word.reversed()
            addFull(wordMap, reversed, index, res)
            addStarting(reversed, wordMap, res, index)
            addEnding(reversed, wordMap, res, index)
        }
        addEmptyAndPalindromes(empty, palindromes, res)
        return res.toList()
    }

    private fun addEmptyAndPalindromes(
        empty: MutableSet<Int>,
        palindromes: MutableSet<Int>,
        res: MutableSet<List<Int>>
    ) {
        for (emptyIndex in empty) {
            for (palindromeIndex in palindromes) {
                res.add(listOf(emptyIndex, palindromeIndex))
                res.add(listOf(palindromeIndex, emptyIndex))
            }
        }
        for (left in empty) {
            for (right in empty) {
                if (left == right) continue
                res.add(listOf(left, right))
                res.add(listOf(right, left))
            }
        }
    }

    private fun addEnding(
        reversed: String,
        wordMap: HashMap<String, Int>,
        res: MutableSet<List<Int>>,
        index: Int
    ) {
        for (i in 1 until reversed.length) {
            val reversedIndex = wordMap[reversed.substring(0, reversed.length - i)]
            if (reversedIndex != null && isPalindrome(reversed.substring(reversed.length - i))) res.add(listOf(reversedIndex, index))
        }
    }

    private fun addStarting(
        reversed: String,
        wordMap: HashMap<String, Int>,
        res: MutableSet<List<Int>>,
        index: Int
    ) {
        for (i in 1 until reversed.length) {
            val reversedIndex = wordMap[reversed.substring(i)]
            if (reversedIndex != null && isPalindrome(reversed.substring(0, i))) res.add(listOf(index, reversedIndex))
        }
    }

    private fun addFull(
        wordMap: HashMap<String, Int>,
        reversed: String,
        index: Int,
        res: MutableSet<List<Int>>
    ) {
        val reversedIndex = wordMap[reversed]
        if (reversedIndex != null && reversedIndex != index) {
            res.add(listOf(index, reversedIndex))
            res.add(listOf(reversedIndex, index))
        }
    }

    private fun isPalindrome(word: String): Boolean {
        for (i in 0 until word.length / 2) {
            if (word[i] != word[word.length - 1 - i]) return false
        }
        return true
    }
}


fun main() {
    val s = E336()
    println(s.palindromePairs(arrayOf("abcd", "dcba", "lls", "s", "sssll")))
    println(s.palindromePairs(arrayOf("bat", "tab", "cat")))
    println(s.palindromePairs(arrayOf("a", "")))
    println(s.palindromePairs(arrayOf("a", "", "ab")))
    println(s.palindromePairs(arrayOf("abc", "dedcba")))
    println(s.palindromePairs(arrayOf("abc", "edcba")))
    println(s.palindromePairs(arrayOf("abcdc", "ba")))
    println(s.palindromePairs(arrayOf("abc", "ba")))
    println(s.palindromePairs(arrayOf("abc", "cba")))
    println(s.palindromePairs(arrayOf("abc", "cba", "abcba", "", "")))
    println(s.palindromePairs(arrayOf("a", "abc", "aba", "")))
}