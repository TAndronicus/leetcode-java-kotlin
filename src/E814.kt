private class E814 {
    fun pruneTree(root: TreeNode?): TreeNode? {
        return if (pruneTreeRecursively(root!!)) null
        else root
    }

    private fun pruneTreeRecursively(node: TreeNode): Boolean {
        var subtreesPrunable = true
        if (node.left != null) {
            val leftPrunable = pruneTreeRecursively(node.left!!)
            subtreesPrunable = subtreesPrunable && leftPrunable
            if (leftPrunable) node.left = null
        }
        if (node.right != null) {
            val rightPrunable = pruneTreeRecursively(node.right!!)
            subtreesPrunable = subtreesPrunable && rightPrunable
            if (rightPrunable) node.right = null
        }
        return subtreesPrunable && node.`val` == 0
    }
}

fun main() {
    val s = E814()
    val firstTree = TreeNode(1)
    firstTree.right = TreeNode(0)
    firstTree.right?.left = TreeNode(0)
    firstTree.right?.right = TreeNode(1)
    val firstRes = s.pruneTree(firstTree)
    println(firstRes != null)
    println(firstRes!!.left == null)
    println(firstRes.right != null)
    println(firstRes.right!!.left == null)
    println(firstRes.right!!.right != null)
    val secondTree = TreeNode(0)
    val secondRes = s.pruneTree(secondTree)
    println(secondRes == null)
    val thirdTree = TreeNode(1)
    thirdTree.left = TreeNode(0)
    thirdTree.left?.left = TreeNode(0)
    thirdTree.left?.right = TreeNode(0)
    thirdTree.right = TreeNode(1)
    thirdTree.right?.left = TreeNode(0)
    thirdTree.right?.right = TreeNode(1)
    val thirdRes = s.pruneTree(thirdTree)
    println(thirdRes != null)
    println(thirdRes!!.left == null)
    println(thirdRes.right != null)
    println(thirdRes.right!!.left == null)
    println(thirdRes.right!!.right != null)
    val fourthTree = TreeNode(1)
    fourthTree.left = TreeNode(1)
    fourthTree.left?.left = TreeNode(1)
    fourthTree.left?.left?.left = TreeNode(0)
    fourthTree.left?.right = TreeNode(1)
    fourthTree.right = TreeNode(0)
    fourthTree.right?.left = TreeNode(0)
    fourthTree.right?.right = TreeNode(1)
    val fourthRes = s.pruneTree(fourthTree)
    println(fourthRes != null)
    println(fourthRes!!.left != null)
    println(fourthRes.left!!.left != null)
    println(fourthRes.left!!.left!!.left == null)
    println(fourthRes.left!!.left!!.right == null)
    println(fourthRes.left!!.right != null)
    println(fourthRes.left!!.right!!.left == null)
    println(fourthRes.left!!.right!!.right == null)
    println(fourthRes.right != null)
    println(fourthRes.right!!.left == null)
    println(fourthRes.right!!.right != null)
    println(fourthRes.right!!.right!!.left == null)
    println(fourthRes.right!!.right!!.right == null)
}