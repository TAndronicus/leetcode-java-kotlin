private class E729 {

    val map = mutableMapOf<Int, Int>()
    fun book(start: Int, end: Int): Boolean {
        return if (map.entries.any { entry -> (entry.value - start) * (end - entry.key) > 0 }) {
            false
        } else {
            map.put(start, end)
            true
        }
    }
}


fun main() {
    val s = E729()
    println(s.book(10, 20))
    println(!s.book(15, 25))
    println(s.book(20, 30))
    println(!s.book(12, 18))
}