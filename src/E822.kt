import java.util.*

private class E822 {
    fun flipgame(fronts: IntArray, backs: IntArray): Int {
        val double = HashSet<Int>()
        val orderedSet = TreeSet<Int>()
        for (i in fronts.indices) {
            if (fronts[i] == backs[i]) double.add(fronts[i])
            else {
                orderedSet.add(fronts[i])
                orderedSet.add(backs[i])
            }
        }
        for (el in orderedSet) {
            if (!double.contains(el)) return el
        }
        return 0
    }
}


fun main() {
    val s = E822()
    println(s.flipgame(intArrayOf(1, 2, 4, 4, 7), intArrayOf(1, 3, 4, 1, 3)) == 2)
    println(s.flipgame(intArrayOf(1), intArrayOf(1)) == 0)
    println(s.flipgame(intArrayOf(1, 1), intArrayOf(1, 2)) == 2)
}