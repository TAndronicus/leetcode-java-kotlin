private class E458 {
    fun poorPigs(buckets: Int, minutesToDie: Int, minutesToTest: Int): Int {
        return Math.ceil(Math.log(buckets.toDouble()) / Math.log(minutesToTest / minutesToDie + 1.0)).toInt()
    }
}


fun main() {
    val s = E458()
    println(s.poorPigs(1000, 15, 60) == 5)
    println(s.poorPigs(4, 15, 15) == 2)
    println(s.poorPigs(4, 15, 30) == 2)
}