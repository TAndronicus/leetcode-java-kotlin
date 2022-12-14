private class BW86E2 {
    fun isStrictlyPalindromic(n: Int): Boolean {
        for (i in 2 until n - 1) {
            if (!isPalindromic(n.toString(i))) return false
        }
        return true
    }

    fun isPalindromic(s: String): Boolean {
        for (i in 0 until s.length / 2) if (s[i] != s[s.length - 1 - i]) return false
        return true
    }
}

fun main() {
    val s = BW86E2()
    println(!s.isStrictlyPalindromic(9))
    println(!s.isStrictlyPalindromic(4))
}