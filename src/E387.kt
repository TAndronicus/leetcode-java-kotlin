private class E387 {
    fun firstUniqChar1(s: String): Int {
        val used = HashMap<Char, Int>()
        val record = ArrayDeque<Pair<Char, Int>>()
        for (el in s.withIndex()) {
            if (!used.containsKey(el.value)) {
                used[el.value] = 1
                record.addLast(Pair(el.value, el.index))
            } else if (used[el.value]!! == 1) {
                used[el.value] = 2
            }
        }
        for (el in record) {
            if (used[el.first] == 1) return el.second
        }
        return -1
    }
}


fun main() {
    val s = E387()
    println(s.firstUniqChar1("leetcode") == 0)
    println(s.firstUniqChar1("loveleetcode") == 2)
    println(s.firstUniqChar1("aabb") == -1)
    println(s.firstUniqChar1("") == -1)
}