private class E100 {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        return (p == null && q == null) || (p != null && q != null && p.`val` == q.`val` && isSameTree(p.left, q.left) && isSameTree(p.right, q.right))
    }
}


fun main() {
    val s = E100()
}