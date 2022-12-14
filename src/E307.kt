@Suppress("CanBePrimaryConstructorProperty")
private class E307(nums: IntArray) {
    val nums = nums

    fun update(index: Int, `val`: Int) {
        nums[index] = `val`
    }

    fun sumRange(left: Int, right: Int): Int {
        var sum = 0
        var pointer = left
        while (pointer <= right) {
            sum += nums[pointer]
            pointer += 1
        }
        return sum
    }

}


fun main() {
    val s = E307(intArrayOf(1, 3, 5))
    println(s.sumRange(0, 2) == 9)
    s.update(1, 2)
    println(s.sumRange(0, 2) == 8)
}