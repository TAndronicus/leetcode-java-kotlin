private class E110 {
    fun isBalanced(root: TreeNode?): Boolean {
        return if (root == null) true
        else minMaxDepth1(root, 1).second
    }

    private fun minMaxDepth1(root: TreeNode, depth: Int): Pair<Int, Boolean> {
        val (leftDepth, leftBalanced) = if (root.left == null) Pair(depth, true) else minMaxDepth1(root.left!!, depth + 1)
        val (rightDepth, rightBalanced) = if (root.right == null) Pair(depth, true) else minMaxDepth1(root.right!!, depth + 1)
        return Pair(maxOf(rightDepth, leftDepth), leftBalanced && rightBalanced && Math.abs(rightDepth - leftDepth) <= 1)
    }

    private fun minMaxDepth(root: TreeNode, currentDepth: Int): Pair<Int, Int> {
        if (root.left == null && root.right == null) return Pair(currentDepth, currentDepth)
        val leftHeight = if (root.left == null) Pair(currentDepth, currentDepth) else minMaxDepth(root.left!!, currentDepth + 1)
        val rightHeight = if (root.right == null) Pair(currentDepth, currentDepth) else minMaxDepth(root.right!!, currentDepth + 1)
        return Pair(minOf(leftHeight.first, rightHeight.first), maxOf(leftHeight.second, rightHeight.second))
    }
}


fun main() {
    val s = E110()
    val firstTree = TreeNode(1)
    firstTree.left = TreeNode(2)
    firstTree.right = TreeNode(3)
    firstTree.right?.right = TreeNode(4)
    firstTree.right?.right?.left = TreeNode(5)
    firstTree.right?.right?.right = TreeNode(6)
    println(!s.isBalanced(firstTree))
    val secondTree = TreeNode(5)
    secondTree.left = TreeNode(4)
    secondTree.right = TreeNode(8)
    secondTree.left?.left = TreeNode(11)
    secondTree.right?.left = TreeNode(13)
    secondTree.right?.right = TreeNode(4)
    secondTree.left?.left?.left = TreeNode(7)
    secondTree.left?.left?.right = TreeNode(2)
    secondTree.right?.right?.left = TreeNode(5)
    secondTree.right?.right?.right = TreeNode(1)
    println(!s.isBalanced(secondTree))
    println(s.isBalanced(null))
    println(s.isBalanced(TreeNode(1)))
    val thirdTree = TreeNode(1)
    thirdTree.right = TreeNode(2)
    println(s.isBalanced(thirdTree))
    thirdTree.left = TreeNode(3)
    println(s.isBalanced(thirdTree))
    thirdTree.left?.left = TreeNode(4)
    println(s.isBalanced(thirdTree))
    thirdTree.left?.left?.right = TreeNode(5)
    println(!s.isBalanced(thirdTree))
    val fourthTree = TreeNode(1)
    fourthTree.left = TreeNode(2)
    fourthTree.right = TreeNode(3)
    fourthTree.left?.left = TreeNode(4)
    fourthTree.left?.right = TreeNode(5)
    fourthTree.right?.left = TreeNode(6)
    fourthTree.left?.left?.left = TreeNode(8)
    println(s.isBalanced(fourthTree))
}