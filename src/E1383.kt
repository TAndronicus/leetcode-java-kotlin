import java.util.*

private class E1383 {
    fun maxPerformance(n: Int, speed: IntArray, efficiency: IntArray, k: Int): Int {
        val queue = PriorityQueue<Int>(k + 1)
        var currentSpeedSum = 0L
        var maxPerformance = 0L
        for ((e, s) in efficiency.zip(speed).sortedByDescending { it.first }) {
            queue.add(s)
            currentSpeedSum += s
            if (queue.size > k) currentSpeedSum -= queue.poll()
            maxPerformance = maxOf(maxPerformance, currentSpeedSum * e)
        }
        return (maxPerformance % (1e9 + 7)).toInt()
    }
}

fun main() {
    val s = E1383()
    println(s.maxPerformance(6, intArrayOf(2, 10, 3, 1, 5, 8), intArrayOf(5, 4, 3, 9, 7, 2), 2) == 60)
    println(s.maxPerformance(6, intArrayOf(2, 10, 3, 1, 5, 8), intArrayOf(5, 4, 3, 9, 7, 2), 3) == 68)
    println(s.maxPerformance(6, intArrayOf(2, 10, 3, 1, 5, 8), intArrayOf(5, 4, 3, 9, 7, 2), 4) == 72)
}