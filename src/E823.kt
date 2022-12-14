private class E823 {
    val modulo = (Math.pow(10.0, 9.0) + 7).toInt()
    fun numFactoredBinaryTrees(arr: IntArray): Int {
        arr.sort()
        val dp = IntArray(arr.size)
        for (i in dp.indices) {
            var left = 0
            var right = i - 1
            var combinations = 1
            while (left <= right) {
                if (arr[left] * arr[right] < arr[i]) left++
                else if (arr[left] * arr[right] > arr[i]) right--
                else {
                    combinations += ((dp[left] * dp[right] * if (left == right) 1 else 2) % modulo)
                    left++
                    right--
                }
            }
            dp[i] = combinations
        }
        return dp.sum() % modulo
    }
}


fun main() {
    val s = E823()
    println(s.numFactoredBinaryTrees(intArrayOf(1)) == 1)
    println(s.numFactoredBinaryTrees(intArrayOf(2, 4)) == 3)
    println(s.numFactoredBinaryTrees(intArrayOf(2, 4, 5, 10)) == 7)
    println(s.numFactoredBinaryTrees(intArrayOf(2, 4, 5, 10, 20)) == 18)
}