private class E112 {
    fun hasPathSum1(root: TreeNode?, targetSum: Int): Boolean {
        return hasPathSum1(root, targetSum, 0)
    }

    private fun hasPathSum1(treeNode: TreeNode?, targetSum: Int, cumSum: Int): Boolean {
        return if (treeNode == null) false
        else if (treeNode.left == null && treeNode.right == null && cumSum + treeNode.`val` == targetSum) true
        else hasPathSum1(treeNode.left, targetSum, cumSum + treeNode.`val`) || hasPathSum1(treeNode.right, targetSum, cumSum + treeNode.`val`)
    }

    fun hasPathSum2(root: TreeNode?, targetSum: Int): Boolean {
        if (root == null) return false
        val queue = ArrayDeque<Pair<TreeNode, Int>>()
        queue.addLast(Pair(root, 0))
        while (queue.isNotEmpty()) {
            val (treeNode, cumSum) = queue.removeFirst()
            if (treeNode.left == null && treeNode.right == null && cumSum + treeNode.`val` == targetSum) return true
            if (treeNode.left != null) queue.addLast(Pair(treeNode.left!!, cumSum + treeNode.`val`))
            if (treeNode.right != null) queue.addLast(Pair(treeNode.right!!, cumSum + treeNode.`val`))
        }
        return false
    }
}


fun main() {
    val s = E112()
    println(!s.hasPathSum1(null, 0))
    println(!s.hasPathSum2(null, 0))
    println(!s.hasPathSum1(TreeNode(1), 0))
    println(!s.hasPathSum2(TreeNode(1), 0))
    println(s.hasPathSum1(TreeNode(1), 1))
    println(s.hasPathSum2(TreeNode(1), 1))
    val firstTree = TreeNode(1)
    firstTree.left = TreeNode(2)
    firstTree.right = TreeNode(3)
    firstTree.right?.right = TreeNode(4)
    firstTree.right?.right?.left = TreeNode(5)
    firstTree.right?.right?.right = TreeNode(6)
    println(s.hasPathSum1(firstTree, 3))
    println(s.hasPathSum2(firstTree, 3))
    println(s.hasPathSum1(firstTree, 13))
    println(s.hasPathSum2(firstTree, 13))
    println(s.hasPathSum1(firstTree, 14))
    println(s.hasPathSum2(firstTree, 14))
    println(!s.hasPathSum1(firstTree, 15))
    println(!s.hasPathSum2(firstTree, 15))
    println(!s.hasPathSum1(firstTree, 12))
    println(!s.hasPathSum2(firstTree, 12))
    println(!s.hasPathSum1(firstTree, 8))
    println(!s.hasPathSum2(firstTree, 8))

}