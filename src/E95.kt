private class E95 {
    fun generateTrees(n: Int): List<TreeNode?> {
        return generateTrees((1..n).toList())
    }

    private fun generateTrees(ar: List<Int>): List<TreeNode?> {
        if (ar.isEmpty()) return listOf(null)
        else if (ar.size == 1) return listOf(TreeNode(ar[0]))
        else {
            val res = mutableListOf<TreeNode>()
            for (i in ar.indices) {
                val leftTrees = generateTrees(ar.take(i))
                val rightTrees = generateTrees(ar.drop(i + 1))
                for (leftTree in leftTrees) {
                    for (rightTree in rightTrees) {
                        val tree = TreeNode(ar[i])
                        tree.left = leftTree
                        tree.right = rightTree
                        res.add(tree)
                    }
                }
            }
            return res
        }
    }
}


fun main() {
    val s = E95()
    println(s.generateTrees(1))
}