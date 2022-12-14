private class E1338 {
    fun minSetSize(arr: IntArray): Int {
        val counts = HashMap<Int, Int>()
        for (el in arr) counts.merge(el, 1) { existing, _ -> existing + 1 }
        var sum = 0
        var count = 0
        for (cnt in counts.values.sortedDescending()) {
            sum += cnt
            count += 1
            if (sum >= arr.size / 2) break
        }
        return count
    }
}


fun main() {
    val s = E1338()
    println(s.minSetSize(intArrayOf(3, 3, 3, 3, 5, 5, 5, 2, 2, 7)) == 2)
    println(s.minSetSize(intArrayOf(7, 7, 7, 7, 7, 7)) == 1)
}