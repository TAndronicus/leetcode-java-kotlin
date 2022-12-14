private class E94 {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        if (root == null) return listOf()
        val res = mutableListOf<Int>()
        inorderTraversalTailrec(root, res)
        return res
    }

    private fun inorderTraversalTailrec(root: TreeNode, res: MutableList<Int>): Unit {
        root.left?.also { inorderTraversalTailrec(it, res) }
        res.add(root.`val`)
        root.right?.also { inorderTraversalTailrec(it, res) }
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TreeNode

        if (`val` != other.`val`) return false
        if (left != other.left) return false
        if (right != other.right) return false

        return true
    }

    override fun hashCode(): Int {
        var result = `val`
        result = 31 * result + (left?.hashCode() ?: 0)
        result = 31 * result + (right?.hashCode() ?: 0)
        return result
    }

}


fun main() {
    val s = E94()
    val tree1 = TreeNode(1)
    tree1.right = TreeNode(2)
    tree1.right?.left = TreeNode(3)
    println(s.inorderTraversal(tree1) == listOf(1, 3, 2))
    val tree2 = null
    println(s.inorderTraversal(tree2) == listOf<Int>())
    val tree3 = TreeNode(1)
    println(s.inorderTraversal(tree3) == listOf(1))
}