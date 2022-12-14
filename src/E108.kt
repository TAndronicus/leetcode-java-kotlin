private class E108 {
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        if (nums.isEmpty()) return null
        val tree = TreeNode(nums[nums.size / 2])
        tree.left = sortedArrayToBST(nums.take(nums.size / 2).toIntArray())
        tree.right = sortedArrayToBST(nums.drop(nums.size / 2 + 1).toIntArray())
        return tree
    }
}


fun main() {
    val s = E108()
    val firstBST = s.sortedArrayToBST(intArrayOf(1, 2, 3, 4, 5))
    val firstExpectedBST = TreeNode(3)
    firstExpectedBST.left = TreeNode(2)
    firstExpectedBST.left?.left = TreeNode(1)
    firstExpectedBST.right = TreeNode(5)
    firstExpectedBST.right?.left = TreeNode(4)
    println(firstBST == firstExpectedBST)
    val secondBST = s.sortedArrayToBST(intArrayOf(1, 2, 3))
    val secondExpectedBST = TreeNode(2)
    secondExpectedBST.left = TreeNode(1)
    secondExpectedBST.right = TreeNode(3)
    println(secondBST == secondExpectedBST)
    val thirdBST = s.sortedArrayToBST(intArrayOf(1, 3))
    val thirdExpectedBST = TreeNode(3)
    thirdExpectedBST.left = TreeNode(1)
    println(thirdBST == thirdExpectedBST)
}