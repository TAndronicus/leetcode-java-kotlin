private class E134 {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        var cumSum = 0
        var min = Int.MAX_VALUE
        var minIndex = 0
        for (diff in gas.zip(cost).map { it.first - it.second }.withIndex()) {
            cumSum += diff.value
            if (cumSum < min) {
                min = cumSum
                minIndex = diff.index
            }
        }
        return if (cumSum < 0) -1
        else if (minIndex == gas.size - 1) 0
        else minIndex + 1
    }
}


fun main() {
    val s = E134()
    println(s.canCompleteCircuit(intArrayOf(3, 1, 1), intArrayOf(1, 2, 2)) == 0)
    println(s.canCompleteCircuit(intArrayOf(1, 2, 3, 4, 5), intArrayOf(3, 4, 5, 1, 2)) == 3)
    println(s.canCompleteCircuit(intArrayOf(2, 3, 4), intArrayOf(3, 4, 3)) == -1)
}