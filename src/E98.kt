private class E98 {
    fun isValidBST(root: TreeNode?): Boolean {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE)
    }

    private fun isValidBST(root: TreeNode?, lo: Long, hi: Long): Boolean {
        return (root == null) || ((lo < root.`val`) && (root.`val` < hi) && isValidBST(root.left, lo, root.`val`.toLong()) && isValidBST(root.right, root.`val`.toLong(), hi))
    }
}


fun main() {
    val s = E98()
    val firstTree = TreeNode(2)
    firstTree.left = TreeNode(1)
    firstTree.right = TreeNode(3)
    println(s.isValidBST(firstTree))
    val secondTree = TreeNode(5)
    secondTree.left = TreeNode(1)
    secondTree.right = TreeNode(4)
    secondTree.right?.left = TreeNode(3)
    secondTree.right?.right = TreeNode(6)
    println(!s.isValidBST(secondTree))
    val thirdTree = TreeNode(5)
    thirdTree.left = TreeNode(1)
    thirdTree.right = TreeNode(6)
    thirdTree.right?.left = TreeNode(5)
    thirdTree.right?.right = TreeNode(7)
    println(!s.isValidBST(thirdTree))
    val fourthTree = TreeNode(2147483647)
    println(s.isValidBST(fourthTree))
}