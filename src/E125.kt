import java.util.*

private class E125 {
    fun isPalindrome(s: String): Boolean {
        val stripped = s.filter { it.isLetter() || it.isDigit() }.lowercase(Locale.getDefault())
        for (i in 0 until stripped.length / 2) {
            if (stripped[i] != stripped[stripped.length - 1 - i]) return false
        }
        return true
    }
}


fun main() {
    val s = E125()
    println(s.isPalindrome("A man, a plan, a canal: Panama"))
    println(!s.isPalindrome("race a car"))
    println(s.isPalindrome(" "))
    println(!s.isPalindrome("0P"))
}