private class E129 {
    fun sumNumbers1(root: TreeNode?): Int {
        return sumNumbersRecursively(root!!, 0)
    }

    private fun sumNumbersRecursively(node: TreeNode, acc: Int): Int {
        return if (node.left == null && node.right == null) 10 * acc + node.`val`
        else if (node.left == null) sumNumbersRecursively(node.right!!, 10 * acc + node.`val`)
        else if (node.right == null) sumNumbersRecursively(node.left!!, 10 * acc + node.`val`)
        else sumNumbersRecursively(node.left!!, 10 * acc + node.`val`) + sumNumbersRecursively(node.right!!, 10 * acc + node.`val`)
    }

    fun sumNumbers2(root: TreeNode?): Int {
        val queue = ArrayDeque<Pair<TreeNode, Int>>()
        queue.add(Pair(root!!, 0))
        var res = 0
        while (queue.isNotEmpty()) {
            val (node, acc) = queue.removeFirst()
            if (node.left == null && node.right == null) res += acc * 10 + node.`val`
            if (node.left != null) queue.add(Pair(node.left!!, 10 * acc + node.`val`))
            if (node.right != null) queue.add(Pair(node.right!!, 10 * acc + node.`val`))
        }
        return res
    }
}


fun main() {
    val s = E129()
    val firstTree = TreeNode(1)
    firstTree.left = TreeNode(2)
    firstTree.right = TreeNode(3)
    println(s.sumNumbers1(firstTree) == 25)
    println(s.sumNumbers2(firstTree) == 25)
    val secondTree = TreeNode(4)
    secondTree.left = TreeNode(9)
    secondTree.left?.left = TreeNode(5)
    secondTree.left?.right = TreeNode(1)
    secondTree.right = TreeNode(0)
    println(s.sumNumbers1(secondTree) == 1026)
    println(s.sumNumbers2(secondTree) == 1026)
}