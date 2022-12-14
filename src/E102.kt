private class E102 {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val res = mutableListOf<MutableList<Int>>()
        levelOrder(root, 0, res)
        return res
    }

    private fun levelOrder(root: TreeNode?, level: Int, acc: MutableList<MutableList<Int>>): Unit {
        if (root != null) {
            if (acc.size <= level) {
                acc.add(mutableListOf(root.`val`))
            } else {
                acc.get(level).add(root.`val`)
            }
            levelOrder(root.left, level + 1, acc)
            levelOrder(root.right, level + 1, acc)
        }
    }
}

private fun e102assert(expected: List<List<Int>>, actual: List<List<Int>>): Boolean {
    if (expected.size != actual.size) return false
    for ((left, right) in expected.zip(actual)) {
        if (left.size != right.size || !left.containsAll(right)) return false
    }
    return true
}


fun main() {
    val s = E102()
    val firstTree = TreeNode(1)
    firstTree.left = TreeNode(2)
    firstTree.right = TreeNode(2)
    firstTree.left?.left = TreeNode(3)
    firstTree.right?.right = TreeNode(3)
    firstTree.left?.right = TreeNode(4)
    firstTree.right?.left = TreeNode(4)
    val res1 = s.levelOrder(firstTree)
    println(e102assert(listOf(listOf(1), listOf(2, 2), listOf(3, 3, 4, 4)), res1))
    val secondTree = TreeNode(3)
    secondTree.left = TreeNode(9)
    secondTree.right = TreeNode(20)
    secondTree.right?.left = TreeNode(15)
    secondTree.right?.right = TreeNode(7)
    val res2 = s.levelOrder(secondTree)
    println(e102assert(listOf(listOf(3), listOf(9, 20), listOf(15, 7)), res2))
    val thirdTree = TreeNode(1)
    val res3 = s.levelOrder(thirdTree)
    println(e102assert(listOf(listOf(1)), res3))
    println(e102assert(listOf(), s.levelOrder(null)))
}