private class E390 {
    fun lastRemaining(n: Int): Int {
        var list = (1 until n + 1).toList()
        while (list.size > 1) list = list.withIndex().filter { it.index % 2 == 1 }.map { it.value }.reversed()
        return list[0]
    }
}


fun main() {
    val s = E390()
    println(s.lastRemaining(1) == 1)
    println(s.lastRemaining(9) == 6)
    for (i in 1 until 50) {
        println("" + i + ": " + s.lastRemaining(i))
    }
}