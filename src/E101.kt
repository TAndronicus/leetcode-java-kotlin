private class E101 {
    fun isSymmetric(root: TreeNode?): Boolean {
        return isSymmetric(root!!.left, root.right)
    }

    private fun isSymmetric(left: TreeNode?, right: TreeNode?): Boolean {
        return (left == null && right == null) || (left != null && right != null && left.`val` == right.`val` && isSymmetric(left.right, right.left) && isSymmetric(
            left.left,
            right.right
        ))
    }
}


fun main() {
    val s = E101()
    val firstTree = TreeNode(1)
    firstTree.left = TreeNode(2)
    firstTree.right = TreeNode(2)
    firstTree.left?.left = TreeNode(3)
    firstTree.right?.right = TreeNode(3)
    firstTree.left?.right = TreeNode(4)
    firstTree.right?.left = TreeNode(4)
    println(s.isSymmetric(firstTree))
    val secondTree = TreeNode(1)
    secondTree.left = TreeNode(2)
    secondTree.right = TreeNode(2)
    secondTree.left?.right = TreeNode(3)
    secondTree.right?.right = TreeNode(3)
    println(!s.isSymmetric(secondTree))
    val thirdTree = TreeNode(1)
    thirdTree.left = TreeNode(2)
    thirdTree.right = TreeNode(2)
    thirdTree.left?.right = TreeNode(3)
    thirdTree.right?.left = TreeNode(3)
    println(s.isSymmetric(thirdTree))
}