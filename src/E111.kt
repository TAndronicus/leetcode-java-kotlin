private class E111 {
    fun sortedListToBST(head: E21.ListNode?): TreeNode? {
        if (head == null) return null
        val ar = toArray(head)
        return constructTree(ar)
    }

    private fun toArray(head: E21.ListNode): List<Int> {
        val array = ArrayDeque<Int>()
        var pointer: E21.ListNode? = head
        while (pointer != null) {
            array.addLast(pointer.`val`)
            pointer = pointer.next
        }
        return array.toList()
    }

    private fun constructTree(ar: List<Int>): TreeNode? {
        if (ar.isEmpty()) return null
        val midIndex = ar.size / 2
        val tree = TreeNode(ar[midIndex])
        tree.left = constructTree(ar.take(midIndex))
        tree.right = constructTree(ar.drop(midIndex + 1))
        return tree
    }
}


fun main() {
    val s = E111()
}