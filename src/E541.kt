private class E541 {
    fun reverseStr(s: String, k: Int): String {
        val sb = StringBuilder()
        for (i in 0 until (s.length / (2 * k) + 1)) {
            val part = s.substring(i * 2 * k, if ((i + 1) * 2 * k > s.length) s.length else (i + 1) * 2 * k)
            if (part.length <= k) sb.append(part.reversed())
            else {
                sb.append(part.substring(0, k).reversed())
                sb.append(part.substring(k))
            }
        }
        return sb.toString()
    }
}


fun main() {
    val s = E541()
    println(s.reverseStr("abcdefg", 2) == "bacdfeg")
    println(s.reverseStr("abcd", 2) == "bacd")
    println(s.reverseStr("abcdefghij", 3) == "cbadefihgj")
    println(s.reverseStr("abcdefgh", 3) == "cbadefhg")
}