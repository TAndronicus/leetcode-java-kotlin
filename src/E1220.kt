private class E1220 {
    fun countVowelPermutation(n: Int): Int {
        val dp = arrayOf(LongArray(n), LongArray(n), LongArray(n), LongArray(n), LongArray(n))
        dp[0][0] = 1
        dp[1][0] = 1
        dp[2][0] = 1
        dp[3][0] = 1
        dp[4][0] = 1
        for (i in 1 until n) {
            dp[0][i] = dp[1][i - 1] + dp[2][i - 1] + dp[4][i - 1]
            dp[1][i] = dp[0][i - 1] + dp[2][i - 1]
            dp[2][i] = dp[1][i - 1] + dp[3][i - 1]
            dp[3][i] = dp[2][i - 1]
            dp[4][i] = dp[2][i - 1] + dp[3][i - 1]
        }
        return ((dp[0][n - 1] + dp[1][n - 1] + dp[2][n - 1] + dp[3][n - 1] + dp[4][n - 1]) % (Math.pow(10.0, 9.0) + 7)).toInt()
    }
}


fun main() {
    val s = E1220()
    println(s.countVowelPermutation(1) == 5)
    println(s.countVowelPermutation(2) == 10)
    println(s.countVowelPermutation(5) == 68)
}