import java.util.*

private class E2007 {
    fun findOriginalArray(changed: IntArray): IntArray {
        if (changed.size % 2 == 1) return intArrayOf()
        val map = changed.toList().groupingBy { it }.eachCount().toSortedMap()
        val res = IntArray(changed.size / 2)
        var counter = 0
        while (map.isNotEmpty()) {
            val current = map.firstKey()
            reduce(map, current)
            if (!map.containsKey(2 * current)) return intArrayOf()
            reduce(map, 2 * current)
            res[counter] = current
            counter++
        }
        return res
    }

    private fun reduce(map: SortedMap<Int, Int>, key: Int) {
        if (map[key] == 1) map.remove(key)
        else map[key] = map[key]!! - 1
    }
}


fun main() {
    val s = E2007()
    println(s.findOriginalArray(intArrayOf(2, 1, 4, 2, 4, 2)).contentEquals(intArrayOf(1, 2, 2)))
    println(s.findOriginalArray(intArrayOf(6, 3, 0, 1)).contentEquals(intArrayOf()))
    println(s.findOriginalArray(intArrayOf(1)).contentEquals(intArrayOf()))
}