private class E114 {
    fun flatten(root: TreeNode?): Unit {
        flattenRecursively(root)
    }

    private fun flattenRecursively(root: TreeNode?): Pair<TreeNode?, TreeNode?> {
        return if (root == null) Pair(null, null)
        else {
            val leftFlat = flattenRecursively(root.left)
            val rightFlat = flattenRecursively(root.right)
            var last = root
            if (leftFlat.first != null) {
                last.right = leftFlat.first
                last = leftFlat.second
            }
            if (rightFlat.first != null) {
                last!!.right = rightFlat.first
                last = rightFlat.second
            }
            root.left = null
            Pair(root, last)
        }
    }
}

fun fromArrayToLinkedListTreeNode(ar: IntArray): TreeNode? {
    val sentinel = TreeNode(0)
    var pointer: TreeNode? = sentinel
    for (el in ar) {
        pointer?.right = TreeNode(el)
        pointer = pointer?.right
    }
    return sentinel.right
}


fun main() {
    val s = E114()
    val firstTree = TreeNode(1)
    firstTree.left = TreeNode(2)
    firstTree.right = TreeNode(3)
    firstTree.right?.right = TreeNode(4)
    firstTree.right?.right?.left = TreeNode(5)
    firstTree.right?.right?.right = TreeNode(6)
    s.flatten(firstTree)
    println(firstTree == fromArrayToLinkedListTreeNode(intArrayOf(1, 2, 3, 4, 5, 6)))
    val secondTree = TreeNode(5)
    secondTree.left = TreeNode(4)
    secondTree.right = TreeNode(8)
    secondTree.left?.left = TreeNode(11)
    secondTree.right?.left = TreeNode(13)
    secondTree.right?.right = TreeNode(4)
    secondTree.left?.left?.left = TreeNode(7)
    secondTree.left?.left?.right = TreeNode(2)
    secondTree.right?.right?.left = TreeNode(5)
    secondTree.right?.right?.right = TreeNode(1)
    s.flatten(secondTree)
    println(secondTree == fromArrayToLinkedListTreeNode(intArrayOf(5, 4, 11, 7, 2, 8, 13, 4, 5, 1)))
}