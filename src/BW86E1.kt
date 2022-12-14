private class BW86E1 {
    fun findSubarrays(nums: IntArray): Boolean {
        val sums = HashSet<Int>()
        for (i in 0 until nums.size - 1) {
            if (sums.contains(nums[i] + nums[i + 1])) return true
            else sums.add(nums[i] + nums[i + 1])
        }
        return false
    }
}

fun main() {
    val s = BW86E1()
    println(s.findSubarrays(intArrayOf(4, 2, 4)))
    println(!s.findSubarrays(intArrayOf(1, 2, 3, 4, 5)))
    println(s.findSubarrays(intArrayOf(0, 0, 0)))
}