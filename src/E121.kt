private class E121 {
    fun maxProfit(prices: IntArray): Int {
        return prices.fold(Pair(prices[0], 0)) { acc, value -> Pair(minOf(acc.first, value), maxOf(acc.second, value - acc.first)) }.second
    }
}


fun main() {
    val s = E121()
    println(s.maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)) == 5)
    println(s.maxProfit(intArrayOf(7, 6, 4, 3, 1)) == 0)
}