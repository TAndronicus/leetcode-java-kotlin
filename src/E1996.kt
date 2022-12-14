private class E1996 {
    fun numberOfWeakCharacters(properties: Array<IntArray>): Int {
        val sorted = properties.sortedByDescending { it[0] }
        var lastAttack = sorted.first()[0]
        var maxDefense = sorted.first()[1]
        for (i in 1 until sorted.size) {
            if (sorted[i][0] != sorted[i - 1][0]) break
            maxDefense = minOf(maxDefense, sorted[i][1])
        }
        var queuedDefense = maxDefense
        var counter = 0
        for (el in sorted) {
            if (el[0] != lastAttack) {
                lastAttack = el[0]
                maxDefense = queuedDefense
            }
            queuedDefense = maxOf(queuedDefense, el[1])
            if (el[1] < maxDefense) counter++
        }
        return counter
    }
}

fun main() {
    val s = E1996()
    println(s.numberOfWeakCharacters(arrayOf(intArrayOf(5, 5), intArrayOf(6, 3), intArrayOf(3, 6))) == 0)
    println(s.numberOfWeakCharacters(arrayOf(intArrayOf(2, 2), intArrayOf(3, 3))) == 1)
    println(s.numberOfWeakCharacters(arrayOf(intArrayOf(1, 5), intArrayOf(10, 4), intArrayOf(4, 3))) == 1)
    println(s.numberOfWeakCharacters(arrayOf(intArrayOf(1, 1), intArrayOf(2, 1), intArrayOf(2, 2), intArrayOf(1, 2))) == 1)
}