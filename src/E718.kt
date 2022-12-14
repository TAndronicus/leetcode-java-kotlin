private class E718 {
    fun findLength1(nums1: IntArray, nums2: IntArray): Int {
        val indices = HashMap<Int, MutableList<Int>>()
        for (el in nums1.withIndex()) {
            if (indices.containsKey(el.value)) indices[el.value]!!.add(el.index)
            else indices[el.value] = mutableListOf(el.index)
        }
        var maxLength = 0
        for (index2 in nums2.indices) {
            if (nums2.size - index2 <= maxLength) break
            if (!indices.containsKey(nums2[index2])) continue
            for (index1 in indices[nums2[index2]]!!) {
                if (nums1.size - index1 <= maxLength) break
                var counter = 0
                while (index1 + counter < nums1.size && index2 + counter < nums2.size && nums1[index1 + counter] == nums2[index2 + counter]) counter++
                maxLength = maxOf(maxLength, counter)
            }
        }
        return maxLength
    }

    fun findLength2(nums1: IntArray, nums2: IntArray): Int {
        val dp = Array(nums1.size + 1) { IntArray(nums2.size + 1) }
        var maxLen = 0
        for (i in nums1.indices.reversed()) {
            for (j in nums2.indices.reversed()) {
                if (nums1[i] == nums2[j]) {
                    dp[i][j] = dp[i + 1][j + 1] + 1
                    maxLen = maxOf(maxLen, dp[i][j])
                }
            }
        }
        return maxLen
    }
}


fun main() {
    val s = E718()
    println(s.findLength1(intArrayOf(1, 2, 3, 2, 1), intArrayOf(3, 2, 1, 4, 7)) == 3)
    println(s.findLength1(intArrayOf(0, 0, 0, 0, 0), intArrayOf(0, 0, 0, 0, 0, 0)) == 5)
    println(s.findLength1(intArrayOf(1, 1, 1, 1), intArrayOf(1, 2, 1, 2, 1, 2, 1)) == 1)
    println(s.findLength2(intArrayOf(1, 2, 3, 2, 1), intArrayOf(3, 2, 1, 4, 7)) == 3)
    println(s.findLength2(intArrayOf(0, 0, 0, 0, 0), intArrayOf(0, 0, 0, 0, 0, 0)) == 5)
    println(s.findLength2(intArrayOf(1, 1, 1, 1), intArrayOf(1, 2, 1, 2, 1, 2, 1)) == 1)
}