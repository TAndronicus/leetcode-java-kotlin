import java.util.*

private class E987 {
    fun verticalTraversal(root: TreeNode?): List<List<Int>> {
        val acc = TreeMap<Int, MutableMap<Int, MutableList<Int>>>()
        verticalTravrsalRecursive(root!!, 0, 0, acc)
        return acc.values
            .map {
                it.values
                    .map { it.sorted() }
                    .flatten()
            }
    }

    private fun verticalTravrsalRecursive(node: TreeNode, row: Int, column: Int, acc: MutableMap<Int, MutableMap<Int, MutableList<Int>>>) {
        if (!acc.contains(column)) acc[column] = TreeMap()
        if (acc[column]!!.contains(row)) acc[column]!![row]!!.add(node.`val`)
        else acc[column]!![row] = mutableListOf(node.`val`)
        if (node.left != null) verticalTravrsalRecursive(node.left!!, row + 1, column - 1, acc)
        if (node.right != null) verticalTravrsalRecursive(node.right!!, row + 1, column + 1, acc)
    }
}

fun main() {
    val s = E987()
    val firstTree = TreeNode(3)
    firstTree.left = TreeNode(9)
    firstTree.right = TreeNode(20)
    firstTree.right?.left = TreeNode(15)
    firstTree.right?.right = TreeNode(7)
    println(s.verticalTraversal(firstTree) == listOf(listOf(9), listOf(3, 15), listOf(20), listOf(7)))
    val secondTree = TreeNode(1)
    secondTree.left = TreeNode(2)
    secondTree.right = TreeNode(3)
    secondTree.left?.left = TreeNode(4)
    secondTree.left?.right = TreeNode(5)
    secondTree.right?.left = TreeNode(6)
    secondTree.right?.right = TreeNode(7)
    println(s.verticalTraversal(secondTree) == listOf(listOf(4), listOf(2), listOf(1, 5, 6), listOf(3), listOf(7)))
    val thirdTree = TreeNode(1)
    thirdTree.left = TreeNode(2)
    thirdTree.right = TreeNode(3)
    thirdTree.left?.left = TreeNode(4)
    thirdTree.left?.right = TreeNode(6)
    thirdTree.right?.left = TreeNode(5)
    thirdTree.right?.right = TreeNode(7)
    println(s.verticalTraversal(thirdTree) == listOf(listOf(4), listOf(2), listOf(1, 5, 6), listOf(3), listOf(7)))
    val fourthTree = TreeNode(3)
    fourthTree.left = TreeNode(1)
    fourthTree.right = TreeNode(4)
    fourthTree.left?.left = TreeNode(0)
    fourthTree.left?.right = TreeNode(2)
    fourthTree.right?.left = TreeNode(2)
    println(s.verticalTraversal(fourthTree) == listOf(listOf(0), listOf(1), listOf(3, 2, 2), listOf(4)))
}