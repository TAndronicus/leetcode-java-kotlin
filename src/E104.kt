private class E104 {
    fun maxDepth(root: TreeNode?): Int {
        return maxDepth(root, 0)
    }

    private fun maxDepth(root: TreeNode?, depth: Int): Int {
        return if (root == null) depth
        else maxOf(depth + 1, maxDepth(root.left, depth + 1), maxDepth(root.right, depth + 1))
    }
}


fun main() {
    val s = E104()
    val firstTree = TreeNode(1)
    firstTree.left = TreeNode(2)
    firstTree.right = TreeNode(2)
    firstTree.left?.left = TreeNode(3)
    firstTree.right?.right = TreeNode(3)
    firstTree.left?.right = TreeNode(4)
    firstTree.right?.left = TreeNode(4)
    println(s.maxDepth(firstTree) == 3)
    val secondTree = TreeNode(3)
    secondTree.left = TreeNode(9)
    secondTree.right = TreeNode(20)
    secondTree.right?.left = TreeNode(15)
    secondTree.right?.right = TreeNode(7)
    println(s.maxDepth(secondTree) == 3)
    val thirdTree = TreeNode(1)
    println(s.maxDepth(thirdTree) == 1)
    val fourthTree = TreeNode(1)
    fourthTree.right = TreeNode(2)
    fourthTree.right?.right = TreeNode(3)
    fourthTree.right?.right?.right = TreeNode(4)
    fourthTree.right?.right?.right?.right = TreeNode(5)
    println(s.maxDepth(fourthTree) == 5)
    println(s.maxDepth(null) == 0)
}