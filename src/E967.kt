private class E967 {
    fun numsSameConsecDiff(n: Int, k: Int): IntArray {
        val currentQueue = ArrayDeque((1 until 10).toList())
        var nextQueue = ArrayDeque<Int>()
        for (i in 1 until n) {
            while (currentQueue.isNotEmpty()) {
                val next = currentQueue.removeFirst()
                val lastDigit = next % 10
                if (lastDigit - k >= 0) nextQueue.add(10 * next + lastDigit - k)
                if (lastDigit + k < 10 && k != 0) nextQueue.add(10 * next + lastDigit + k)
            }
            currentQueue.addAll(nextQueue)
            nextQueue = ArrayDeque()
        }
        return currentQueue.toIntArray()
    }
}

fun main() {
    val s = E967()
    println(s.numsSameConsecDiff(3, 7).contentEquals(intArrayOf(181, 292, 707, 818, 929)))
    println(s.numsSameConsecDiff(2, 1).contentEquals(intArrayOf(10, 12, 21, 23, 32, 34, 43, 45, 54, 56, 65, 67, 76, 78, 87, 89, 98)))
    println(s.numsSameConsecDiff(2, 0).contentEquals(intArrayOf(11, 22, 33, 44, 55, 66, 77, 88, 99)))
}