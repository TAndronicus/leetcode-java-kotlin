private class E228 {
    fun summaryRanges(nums: IntArray): List<String> {
        if (nums.isEmpty()) return listOf()
        if (nums.size == 1) return listOf(nums[0].toString())
        val res = mutableListOf<String>()
        var first = nums[0]
        var last = nums[0]
        for (el in nums.drop(1)) {
            if (el == last + 1) last++
            else {
                res.add(if (first == last) first.toString() else "$first->$last")
                first = el
                last = el
            }
        }
        res.add(if (first == last) first.toString() else "$first->$last")
        return res
    }
}


fun main() {
    val s = E228()
    println(s.summaryRanges(intArrayOf(0, 1, 2, 4, 5, 7)) == listOf("0->2", "4->5", "7"))
    println(s.summaryRanges(intArrayOf(0, 2, 3, 4, 6, 8, 9)) == listOf("0", "2->4", "6", "8->9"))
}