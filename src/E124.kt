private class E124 {
    fun maxPathSum(root: TreeNode?): Int {
        return maxPathSum(root!!).first
    }

    private fun maxPathSum(root: TreeNode): Pair<Int, Int> { // (max path sum, max path)
        return if (root.left == null && root.right == null) Pair(root.`val`, root.`val`)
        else if (root.left != null && root.right != null) {
            val left = maxPathSum(root.left!!)
            val right = maxPathSum(root.right!!)
            Pair(maxOf(left.first, right.first, maxOf(0, left.second) + maxOf(0, right.second) + root.`val`), maxOf(left.second, right.second, 0) + root.`val`)
        } else if (root.left != null) {
            val left = maxPathSum(root.left!!)
            Pair(maxOf(left.first, maxOf(0, left.second) + root.`val`), maxOf(left.second, 0) + root.`val`)
        } else {
            val right = maxPathSum(root.right!!)
            Pair(maxOf(right.first, maxOf(0, right.second) + root.`val`), maxOf(right.second, 0) + root.`val`)
        }
    }
}


fun main() {
    val s = E124()
    val firstTree = TreeNode(1)
    firstTree.left = TreeNode(2)
    firstTree.right = TreeNode(3)
    println(s.maxPathSum(firstTree) == 6)
    val secondTree = TreeNode(-10)
    secondTree.left = TreeNode(9)
    secondTree.right = TreeNode(20)
    secondTree.right?.left = TreeNode(15)
    secondTree.right?.right = TreeNode(7)
    println(s.maxPathSum(secondTree) == 42)
    println(s.maxPathSum(TreeNode((1))) == 1)
    val thirdTree = TreeNode(2)
    thirdTree.left = TreeNode(-1)
    println(s.maxPathSum(thirdTree) == 2)
    val fourthTree = TreeNode(9)
    fourthTree.left = TreeNode(6)
    fourthTree.right = TreeNode(-3)
    fourthTree.right?.left = TreeNode(-6)
    fourthTree.right?.right = TreeNode(2)
    fourthTree.right?.right?.left = TreeNode(2)
    fourthTree.right?.right?.left?.left = TreeNode(-6)
    fourthTree.right?.right?.left?.right = TreeNode(-6)
    fourthTree.right?.right?.left?.left?.left = TreeNode(-6)
    println(s.maxPathSum(fourthTree) == 16)
}