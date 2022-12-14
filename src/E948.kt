private class E948 {
    fun bagOfTokensScore(tokens: IntArray, power: Int): Int {
        val sorted = ArrayDeque(tokens.sorted())
        var currentScore = 0
        var currentPower = power
        var maxScore = 0
        while (sorted.isNotEmpty()) {
            if (sorted.first() <= currentPower) {
                currentPower -= sorted.removeFirst()
                currentScore++
                maxScore = maxOf(maxScore, currentScore)
            } else if (currentScore > 0) {
                currentPower += sorted.removeLast()
                currentScore--
            } else break
        }
        return maxScore
    }
}

fun main() {
    val s = E948()
    println(s.bagOfTokensScore(intArrayOf(100), 50) == 0)
    println(s.bagOfTokensScore(intArrayOf(100, 200), 150) == 1)
    println(s.bagOfTokensScore(intArrayOf(100, 200, 300, 400), 200) == 2)
}