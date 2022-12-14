private class E238 {
    fun productExceptSelf(nums: IntArray): IntArray {
        var product = 1
        var zeroIndex = -1
        for (el in nums.withIndex()) {
            if (el.value != 0) product *= el.value
            else if (zeroIndex == -1) zeroIndex = el.index
            else return IntArray(nums.size)
        }
        return if (zeroIndex == -1) IntArray(nums.size) { index -> product / nums[index] }
        else {
            val res = IntArray(nums.size)
            res[zeroIndex] = product
            res
        }
    }
}


fun main() {
    val s = E238()
    println(s.productExceptSelf(intArrayOf(1, 2, 3, 4)).contentEquals(intArrayOf(24, 12, 8, 6)))
    println(s.productExceptSelf(intArrayOf(-1, 1, 0, -3, 3)).contentEquals(intArrayOf(0, 0, 9, 0, 0)))
    println(s.productExceptSelf(intArrayOf(-1, 1, 0, -3, 3, 0)).contentEquals(intArrayOf(0, 0, 0, 0, 0, 0)))
}