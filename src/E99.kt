private class E99 {
    fun recoverTree(root: TreeNode?): Unit {
        recoverTree(root!!)
    }

    private fun recoverTree(root: TreeNode): Boolean {
        if (root.left != null && root.`val` < root.left!!.`val`) {
            swap(root, root.left!!)
            return true
        }
        if (root.right != null && root.`val` > root.right!!.`val`) {
            swap(root, root.right!!)
            return true
        }
        if (root.left != null && recoverTree(root.left!!)) return true
        if (root.right != null && recoverTree(root.right!!)) return true
        return false
    }

    private fun swap(parent: TreeNode, child: TreeNode): Unit {
        val parentVal = parent.`val`
        parent.`val` = child.`val`
        child.`val` = parentVal
    }
}


fun main() {
    val s = E99()
    val firstTree = TreeNode(1)
    firstTree.left = TreeNode(3)
    firstTree.left?.right = TreeNode(2)
    s.recoverTree(firstTree)
    println(firstTree.`val` == 3)
    println(firstTree.left?.`val` == 1)
    println(firstTree.left?.right?.`val` == 2)
}