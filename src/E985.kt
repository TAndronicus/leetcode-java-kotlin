private class E985 {
    fun sumEvenAfterQueries(nums: IntArray, queries: Array<IntArray>): IntArray {
        var currentSum = nums.filter { it % 2 == 0 }.sum()
        val res = IntArray(queries.size)
        for (index in queries.indices) {
            if (nums[queries[index][1]] % 2 == 0) {
                if (queries[index][0] % 2 == 0) currentSum += queries[index][0]
                else currentSum -= nums[queries[index][1]]
            } else {
                if (queries[index][0] % 2 != 0) currentSum += queries[index][0] + nums[queries[index][1]]
            }
            nums[queries[index][1]] += queries[index][0]
            res[index] = currentSum
        }
        return res
    }
}


fun main() {
    val s = E985()
    println(s.sumEvenAfterQueries(intArrayOf(1, 2, 3, 4), arrayOf(intArrayOf(1, 0), intArrayOf(-3, 1), intArrayOf(-4, 0), intArrayOf(2, 3))).joinToString())
    println(s.sumEvenAfterQueries(intArrayOf(1), arrayOf(intArrayOf(4, 0))).joinToString())
}