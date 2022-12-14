private class E90 {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        val res: MutableList<List<Int>> = mutableListOf(emptyList())
        nums.sort()
        var previousNum = -11
        var previousRes: MutableList<List<Int>> = mutableListOf()
        for (num: Int in nums) {
            res.addAll(previousRes)
            val newRes: MutableList<List<Int>> = mutableListOf()
            if (previousNum == num) {
                for (el: List<Int> in previousRes) {
                    newRes.add(el + num)
                }
            } else {
                for (el: List<Int> in res) {
                    newRes.add(el + num)
                }
            }
            previousRes = newRes
            previousNum = num
        }
        res.addAll(previousRes)
        return res
    }
}

fun main() {
    val s = E90()
    println(s.subsetsWithDup(intArrayOf(1)) == listOf(listOf(), listOf(1)))
    println(s.subsetsWithDup(intArrayOf(1, 2, 3)) == listOf(listOf(), listOf(1), listOf(2), listOf(1, 2), listOf(3), listOf(1, 3), listOf(2, 3), listOf(1, 2, 3)))
    println(s.subsetsWithDup(intArrayOf(1, 2, 2)) == listOf(listOf(), listOf(1), listOf(2), listOf(1, 2), listOf(2, 2), listOf(1, 2, 2)))
    println(s.subsetsWithDup(intArrayOf(2, 2, 2)) == listOf(listOf(), listOf(2), listOf(2, 2), listOf(2, 2, 2)))
    println(s.subsetsWithDup(intArrayOf(2, 2, 2)))
}