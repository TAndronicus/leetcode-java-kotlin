private class E139 {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val dp = BooleanArray(s.length)
        for (el in s.indices) {
            for (word in wordDict) {
                if (el - word.length >= -1 && s.substring(el - word.length + 1, el + 1) == word && (el == word.length - 1 || dp[el - word.length])) {
                    dp[el] = true
                    break
                }
            }
        }
        return dp.last()
    }
}


fun main() {
    val s = E139()
    println(s.wordBreak("leetcode", listOf("code", "leet")))
    println(s.wordBreak("applepenapple", listOf("apple", "pen")))
    println(!s.wordBreak("catsandog", listOf("cats", "dog", "sand", "and", "cat")))
    println(s.wordBreak("a", listOf("a")))
}