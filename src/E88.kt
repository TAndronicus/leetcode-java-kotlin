private class E88 {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var left = m - 1
        var right = n - 1
        var midIndex = m + n - 1
        while (left != -1 || right != -1) {
            if (left >= 0 && (right < 0 || nums1[left] >= nums2[right])) {
                nums1[midIndex] = nums1[left]
                left--
            } else {
                nums1[midIndex] = nums2[right]
                right--
            }
            midIndex--
        }
    }
}

fun assertMerge(nums1: IntArray, m: Int, nums2: IntArray, n: Int, result: IntArray): Unit {
    val s = E88()
    s.merge(nums1, m, nums2, n)
    println(nums1.contentEquals(result))
}

fun main() {
    assertMerge(intArrayOf(1, 2, 3, 0, 0, 0), 3, intArrayOf(2, 5, 6), 3, intArrayOf(1, 2, 2, 3, 5, 6))
    assertMerge(intArrayOf(1), 1, intArrayOf(), 0, intArrayOf(1))
    assertMerge(intArrayOf(0), 0, intArrayOf(1), 1, intArrayOf(1))
}