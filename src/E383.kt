private class E383 {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        if (ransomNote.length > magazine.length) return false
        else {
            val characters = HashMap<Char, Int>()
            for (ch in magazine) characters.merge(ch, 1) { existing, _ -> existing + 1 }
            for (ch in ransomNote) {
                if (!characters.containsKey(ch) || characters[ch] == 0) return false
                characters[ch] = characters[ch]!! - 1
            }
            return true
        }
    }
}


fun main() {
    val s = E383()
    println(!s.canConstruct("a", "b"))
    println(!s.canConstruct("aa", "ab"))
    println(s.canConstruct("aa", "aab"))
}