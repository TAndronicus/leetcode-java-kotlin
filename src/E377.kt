private class E377 {
    fun combinationSum4_1(nums: IntArray, target: Int): Int {
        val queue = ArrayDeque<Int>()
        queue.add(0)
        var res = 0
        while (queue.isNotEmpty()) {
            val next = queue.removeFirst()
            for (num in nums) {
                if (next + num == target) res++
                else if (next + num < target) queue.add(next + num)
            }
        }
        return res
    }

    fun combinationSum4_2(nums: IntArray, target: Int): Int {
        return if (target == 0) 1
        else {
            var res = 0
            for (num in nums) {
                if (target >= num) res += combinationSum4_2(nums, target - num)
            }
            res
        }
    }

    fun combinationSum4_3(nums: IntArray, target: Int): Int {
        val res = IntArray(target + 1)
        res[0] = 1
        nums.sort()
        for (i in 1 until target + 1) {
            for (num in nums) {
                if (num > i) break
                else if (num == i) res[i]++
                else res[i] += res[i - num]
            }
        }
        return res[target]
    }
}


fun main() {
    val s = E377()
    println(s.combinationSum4_1(intArrayOf(1, 2, 3), 4) == 7)
    println(s.combinationSum4_1(intArrayOf(9), 3) == 0)
    println(s.combinationSum4_1(intArrayOf(2), 3) == 0)
    println(s.combinationSum4_2(intArrayOf(1, 2, 3), 4) == 7)
    println(s.combinationSum4_2(intArrayOf(9), 3) == 0)
    println(s.combinationSum4_2(intArrayOf(2), 3) == 0)
    println(s.combinationSum4_3(intArrayOf(1, 2, 3), 4) == 7)
    println(s.combinationSum4_3(intArrayOf(9), 3) == 0)
    println(s.combinationSum4_3(intArrayOf(2), 3) == 0)
}