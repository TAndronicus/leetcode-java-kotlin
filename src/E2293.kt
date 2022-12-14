private class E2293 {
    fun minMaxGame(nums: IntArray): Int {
        return if (nums.size == 1) nums[0]
        else {
            var curLen = nums.size / 2
            while (curLen > 1) {
                for (i in 0 until curLen) {
                    nums[i] = if (i % 2 == 0) minOf(nums[2 * i], nums[2 * i + 1]) else maxOf(nums[2 * i], nums[2 * i + 1])
                }
                curLen /= 2
            }
            minOf(nums[0], nums[1])
        }
    }
}


fun main() {
    val s = E2293()
    println(s.minMaxGame(intArrayOf(1, 3, 5, 2, 4, 8, 2, 2)) == 1)
    println(s.minMaxGame(intArrayOf(3)) == 3)
}