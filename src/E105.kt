private class E105 {
    lateinit var inorderIndexes: HashMap<Int, Int>
    fun buildTree1(preorder: IntArray, inorder: IntArray): TreeNode? {
        return buildTree1(preorder.toList(), inorder.toList())
    }

    private fun buildTree1(preorder: List<Int>, inorder: List<Int>): TreeNode? {
        return if (preorder.isEmpty()) null
        else {
            val rootVal = preorder.first()
            val inorderIndex = inorder.indexOf(rootVal)
            val tree = TreeNode(rootVal)
            tree.left = buildTree1(preorder.drop(1).take(inorderIndex), inorder.take(inorderIndex))
            tree.right = buildTree1(preorder.drop(1 + inorderIndex), inorder.drop(1 + inorderIndex))
            tree
        }
    }
}


fun main() {
    val s = E105()
    val firstTree = TreeNode(3)
    firstTree.left = TreeNode(9)
    firstTree.right = TreeNode(20)
    firstTree.right?.left = TreeNode(15)
    firstTree.right?.right = TreeNode(7)
    println(s.buildTree1(intArrayOf(3, 9, 20, 15, 7), intArrayOf(9, 3, 15, 20, 7)) == firstTree)
    val secondTree = TreeNode(1)
    secondTree.left = TreeNode(2)
    secondTree.right = TreeNode(3)
    secondTree.left?.left = TreeNode(4)
    secondTree.right?.left = TreeNode(5)
    secondTree.right?.right = TreeNode(6)
    secondTree.right?.right?.left = TreeNode(7)
    println(s.buildTree1(intArrayOf(1, 2, 4, 3, 5, 6, 7), intArrayOf(4, 2, 1, 5, 3, 7, 6)) == secondTree)
    println(s.buildTree1(intArrayOf(-1), intArrayOf(-1)) == TreeNode(-1))
}