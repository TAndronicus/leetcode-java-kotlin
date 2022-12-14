private class E113 {
    fun hasPathSum2(root: TreeNode?, targetSum: Int): List<List<Int>> {
        if (root == null) return listOf()
        val queue = ArrayDeque<Triple<TreeNode, List<Int>, Int>>()
        val res = mutableListOf<List<Int>>()
        queue.addLast(Triple(root, listOf(), 0))
        while (queue.isNotEmpty()) {
            val (treeNode, route, cumSum) = queue.removeFirst()
            val newRoute = route.plus(treeNode.`val`)
            if (treeNode.left == null && treeNode.right == null && cumSum + treeNode.`val` == targetSum) {
                res.add(newRoute)
                continue
            }
            if (treeNode.left != null) queue.addLast(Triple(treeNode.left!!, newRoute, cumSum + treeNode.`val`))
            if (treeNode.right != null) queue.addLast(Triple(treeNode.right!!, newRoute, cumSum + treeNode.`val`))
        }
        return res
    }
}


fun main() {
    val s = E113()
    println(s.hasPathSum2(null, 0).isEmpty())
    println(s.hasPathSum2(TreeNode(1), 0).isEmpty())
    println(s.hasPathSum2(TreeNode(1), 1).contains(listOf(1)))
    println(s.hasPathSum2(TreeNode(1), 1).size == 1)
    val firstTree = TreeNode(1)
    firstTree.left = TreeNode(2)
    firstTree.right = TreeNode(3)
    firstTree.right?.right = TreeNode(4)
    firstTree.right?.right?.left = TreeNode(5)
    firstTree.right?.right?.right = TreeNode(6)
    println(s.hasPathSum2(firstTree, 3).size == 1)
    println(s.hasPathSum2(firstTree, 3).contains(listOf(1, 2)))
    println(s.hasPathSum2(firstTree, 13).size == 1)
    println(s.hasPathSum2(firstTree, 13).contains(listOf(1, 3, 4, 5)))
    println(s.hasPathSum2(firstTree, 14).size == 1)
    println(s.hasPathSum2(firstTree, 14).contains(listOf(1, 3, 4, 6)))
    println(s.hasPathSum2(firstTree, 15).isEmpty())
    println(s.hasPathSum2(firstTree, 12).isEmpty())
    println(s.hasPathSum2(firstTree, 8).isEmpty())
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
    println(s.hasPathSum2(secondTree, 22).size == 2)
    println(s.hasPathSum2(secondTree, 22).containsAll(listOf(listOf(5, 4, 11, 2), listOf(5, 8, 4, 5))))
}