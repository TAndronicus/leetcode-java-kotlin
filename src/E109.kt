private class E109 {
    fun minDepth1(root: TreeNode?): Int {
        return if (root == null) 0
        else minDepth1(root, 1)
    }

    private fun minDepth1(root: TreeNode, minLevel: Int): Int {
        return if (root.left == null && root.right == null) minLevel
        else {
            val first = if (root.left != null) minDepth1(root.left!!, minLevel + 1) else Int.MAX_VALUE
            val second = if (root.right != null) minDepth1(root.right!!, minLevel + 1) else Int.MAX_VALUE
            minOf(first, second)
        }
    }

    fun minDepth2(root: TreeNode?): Int {
        if (root == null) return 0
        val queue = ArrayDeque<Pair<TreeNode, Int>>()
        queue.addLast(Pair(root, 1))
        while (true) {
            val (tree, level) = queue.removeFirst()
            if (tree.left == null && tree.right == null) return level
            if (tree.left != null) queue.addLast(Pair(tree.left!!, level + 1))
            if (tree.right != null) queue.addLast(Pair(tree.right!!, level + 1))
        }
    }
}


fun main() {
    val s = E109()
    val firstTree = TreeNode(1)
    firstTree.left = TreeNode(2)
    firstTree.right = TreeNode(3)
    firstTree.left?.left = TreeNode(4)
    firstTree.right?.right = TreeNode(5)
    println(s.minDepth1(firstTree) == 3)
    println(s.minDepth2(firstTree) == 3)
    val secondTree = TreeNode(1)
    secondTree.right = TreeNode(2)
    println(s.minDepth1(secondTree) == 2)
    println(s.minDepth2(secondTree) == 2)
    println(s.minDepth1(TreeNode(0)) == 1)
    println(s.minDepth2(TreeNode(0)) == 1)
    println(s.minDepth1(null) == 0)
    println(s.minDepth2(null) == 0)
    val thirdTree = TreeNode(1)
    thirdTree.right = TreeNode(2)
    thirdTree.right?.right = TreeNode(3)
    thirdTree.right?.right?.right = TreeNode(4)
    println(s.minDepth1(thirdTree) == 4)
    println(s.minDepth2(thirdTree) == 4)
    val fourthTree = TreeNode(1)
    fourthTree.left = TreeNode(2)
    fourthTree.right = TreeNode(3)
    fourthTree.right?.right = TreeNode(4)
    println(s.minDepth1(fourthTree) == 2)
    println(s.minDepth2(fourthTree) == 2)
}