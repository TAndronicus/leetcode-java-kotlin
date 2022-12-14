private class E916 {
    fun wordSubsets(words1: Array<String>, words2: Array<String>): List<String> {
        val required = mutableMapOf<Char, Int>()
        words2.map { it.groupingBy { it }.eachCount() }
            .forEach { it.forEach { entry -> required.merge(entry.key, entry.value, ::maxOf) } }
        return words1
            .filter { contains(it, required.toMutableMap()) }
    }

    private fun contains(word: String, chars: MutableMap<Char, Int>): Boolean {
        for (c in word) {
            if (chars.none()) return true
            val count = chars.remove(c)
            if (count != null) {
                if (count > 1) chars.put(c, count - 1)
            }
        }
        return chars.none()
    }
}


fun main() {
    val s = E916()
    println(s.wordSubsets(arrayOf("amazon", "apple", "facebook", "google", "leetcode"), arrayOf("e", "o")) == listOf("facebook", "google", "leetcode"))
    println(s.wordSubsets(arrayOf("amazon", "apple", "facebook", "google", "leetcode"), arrayOf("l", "e")) == listOf("apple", "google", "leetcode"))
}