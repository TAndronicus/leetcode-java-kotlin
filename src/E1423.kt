private class E1423 {
    fun maxScore(cardPoints: IntArray, k: Int): Int {
        if (k == cardPoints.size) return cardPoints.sum()
        var currentSum = cardPoints.take(k).sum()
        var maxSum = currentSum
        for (i in 1 until k + 1) {
            currentSum = currentSum - cardPoints[k - i] + cardPoints[cardPoints.size - i]
            maxSum = maxOf(maxSum, currentSum)
        }
        return maxSum
    }
}


fun main() {
    val s = E1423()
    println(s.maxScore(intArrayOf(1, 2, 3, 4, 5, 6, 1), 3) == 12)
    println(s.maxScore(intArrayOf(2, 2, 2), 2) == 4)
    println(s.maxScore(intArrayOf(9, 7, 7, 9, 7, 7, 9), 7) == 55)
}