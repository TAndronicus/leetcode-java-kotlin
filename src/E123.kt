private class E123 {
    val FIRST_COMP = Comparator { c1: IntArray, c2: IntArray -> (c1[0] - c1[1]).compareTo(c2[0] - c2[1]) }
    val SECOND_COMP = Comparator { c1: IntArray, c2: IntArray ->
        val res = FIRST_COMP.compare(c1, c2)
        if (res != 0) res else c1[0].compareTo(c2[0])
    }

    fun maxProfit(prices: IntArray): Int {
        val res = intArrayOf(prices[0], prices[0], prices[0], prices[0], prices[0], prices[0])
        for (price in prices) {
            if (price >= res[5]) res[5] = price
            else fold2(res, price)
        }
        fold2(res, 0)
        return res[1] + res[3] - res[0] - res[2]
    }

    private fun fold2(extremes: IntArray, currentPrice: Int): Unit {
        val len1 = extremes[1] - extremes[0]
        val len2 = extremes[3] - extremes[2]
        val len3 = extremes[5] - extremes[4]
        if (len1 < len3 || len2 < len3) {
            val left = listOf(intArrayOf(extremes[0], extremes[1]), intArrayOf(extremes[2], extremes[3]), intArrayOf(extremes[0], extremes[3]))
                .sortedWith(SECOND_COMP)
                .first()
            val right = listOf(intArrayOf(extremes[2], extremes[3]), intArrayOf(extremes[4], extremes[5]), intArrayOf(extremes[2], extremes[5]))
                .sortedWith(SECOND_COMP)
                .first()
            if (left[1] - left[0] + extremes[5] - extremes[4] >= right[1] - right[0] + extremes[1] - extremes[0]) {
                extremes[0] = left[0]
                extremes[1] = left[1]
                extremes[2] = extremes[4]
                extremes[3] = extremes[5]
            } else {
                extremes[2] = right[0]
                extremes[3] = right[1]
            }
            extremes[4] = currentPrice
            extremes[5] = currentPrice
        } else if (currentPrice < extremes[5]) {
            extremes[3] = maxOf(extremes[3], extremes[5])
            extremes[4] = currentPrice
            extremes[5] = currentPrice
        }
    }

    private fun fold(extremes: IntArray, currentPrice: Int): Unit {
        val len1 = extremes[1] - extremes[0]
        val len2 = extremes[3] - extremes[2]
        val len3 = extremes[5] - extremes[4]
        if (len1 <= len2 && len1 <= len3) {
            if (extremes[0] < extremes[2]) {
                extremes[1] = extremes[3]
            } else {
                extremes[0] = extremes[2]
                extremes[1] = extremes[3]
            }
            extremes[2] = extremes[4]
            extremes[3] = extremes[5]
            extremes[4] = currentPrice
            extremes[5] = currentPrice
        } else if (len2 <= len1 && len2 <= len3) {
            if (extremes[3] - extremes[1] >= extremes[4] - extremes[2]) {
                extremes[1] = maxOf(extremes[1], extremes[3])
                extremes[2] = extremes[4]
                extremes[3] = extremes[5]
            } else {
                extremes[2] = minOf(extremes[2], extremes[4])
                extremes[3] = extremes[5]
            }
            extremes[4] = currentPrice
            extremes[5] = currentPrice
        } else if (currentPrice < extremes[5]) {
            extremes[3] = maxOf(extremes[3], extremes[5])
            extremes[4] = currentPrice
            extremes[5] = currentPrice
        }
    }
}


fun main() {
    val s = E123()
    println(s.maxProfit(intArrayOf(3, 3, 5, 0, 0, 3, 1, 4)) == 6)
    println(s.maxProfit(intArrayOf(1, 2, 3, 4, 5)) == 4)
    println(s.maxProfit(intArrayOf(7, 6, 4, 3, 1)) == 0)
    println(s.maxProfit(intArrayOf(7, 8, 9, 6, 7, 5, 6, 4, 5, 3, 4, 2, 3)) == 3)
    println(s.maxProfit(intArrayOf(8, 9, 7, 8, 6, 7, 5, 6, 1, 9, 1, 9)) == 16)
    println(s.maxProfit(intArrayOf(1, 9, 1, 9, 2, 8, 3, 7, 2, 8, 1, 9)) == 16)
    println(s.maxProfit(intArrayOf(9, 8, 7, 6, 5, 4, 3, 2, 1, 9)) == 8)
    println(s.maxProfit(intArrayOf(1, 2, 4, 2, 5, 7, 2, 4, 9, 0, 9)) == 17)
    println(s.maxProfit(intArrayOf(1, 3, 5, 4, 3, 7, 6, 9, 2, 4)) == 10)
    println(s.maxProfit(intArrayOf(8, 3, 6, 2, 8, 8, 8, 4, 2, 0, 7, 2, 9, 4, 9)) == 15)
}