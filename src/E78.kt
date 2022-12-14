private class E78 {
    fun subsets(nums: IntArray): List<List<Int>> {
        val res: MutableList<List<Int>> = mutableListOf(emptyList())
        for (num: Int in nums) {
            val newRes: MutableList<List<Int>> = mutableListOf()
            for (el: List<Int> in res) {
                newRes.add(el + num)
            }
            res.addAll(newRes)
        }
        return res
    }
}

fun main() {
    val s = E78()
    println(s.subsets(intArrayOf(1)) == listOf(listOf(), listOf(1)))
    println(s.subsets(intArrayOf(1, 2, 3)) == listOf(listOf(), listOf(1), listOf(2), listOf(1, 2), listOf(3), listOf(1, 3), listOf(2, 3), listOf(1, 2, 3)))
}