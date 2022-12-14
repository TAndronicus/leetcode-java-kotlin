private class E122 {
    fun maxProfit(prices: IntArray): Int {
        return prices.fold(Triple(prices[0], prices[0], 0)) { acc, value ->
            if (value >= acc.second) Triple(acc.first, value, acc.third + value - acc.second)
            else Triple(value, value, acc.third)
        }.third
    }
}


fun main() {
    val s = E122()
    println(s.maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)) == 7)
    println(s.maxProfit(intArrayOf(1, 2, 3, 4, 5)) == 4)
    println(s.maxProfit(intArrayOf(7, 6, 4, 3, 1)) == 0)
}