private class E804 {
    private val morseCode = hashMapOf(
        'a' to ".-",
        'b' to "-...",
        'c' to "-.-.",
        'd' to "-..",
        'e' to ".",
        'f' to "..-.",
        'g' to "--.",
        'h' to "....",
        'i' to "..",
        'j' to ".---",
        'k' to "-.-",
        'l' to ".-..",
        'm' to "--",
        'n' to "-.",
        'o' to "---",
        'p' to ".--.",
        'q' to "--.-",
        'r' to ".-.",
        's' to "...",
        't' to "-",
        'u' to "..-",
        'v' to "...-",
        'w' to ".--",
        'x' to "-..-",
        'y' to "-.--",
        'z' to "--.."
    )

    fun uniqueMorseRepresentations(words: Array<String>): Int {
        val res = HashSet<String>()
        for (word in words) {
            res.add(transform(word))
        }
        return res.size
    }

    private fun transform(word: String): String {
        return word.map { morseCode[it] }.joinToString(separator = "") { it!! }
    }
}


fun main() {
    val s = E804()
    println(s.uniqueMorseRepresentations(arrayOf("gin", "zen", "gig", "msg")) == 2)
    println(s.uniqueMorseRepresentations(arrayOf("a")) == 1)
}