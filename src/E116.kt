class Node(var `val`: Int) {
    var left: Node? = null
    var right: Node? = null
    var next: Node? = null
}

private class E116 {
    fun connect(root: Node?): Node? {
        if (root == null) return null
        var queue = ArrayDeque<Node>()
        queue.add(root)
        var awaiting = ArrayDeque<Node>()
        while (queue.isNotEmpty()) {
            var pointer: Node? = null
            while (queue.isNotEmpty()) {
                // populate next
                val next = queue.removeFirst()
                pointer?.next = next
                pointer = next
                // refill queue
                if (next.left != null) awaiting.addLast(next.left!!)
                if (next.right != null) awaiting.addLast(next.right!!)
            }
            queue = awaiting
            awaiting = ArrayDeque()
        }
        return root
    }
}


fun main() {
    val s = E116()
    val firstTree = Node(1)
    firstTree.left = Node(2)
    firstTree.right = Node(3)
    firstTree.left?.left = Node(4)
    firstTree.left?.right = Node(5)
    firstTree.right?.left = Node(6)
    firstTree.right?.right = Node(7)
    val firstConnected = s.connect(firstTree)
    println(firstConnected!!.next == null)
    println(firstConnected.left!!.next!!.`val` == 3)
    println(firstConnected.right!!.next == null)
    println(firstConnected.left!!.left!!.next!!.`val` == 5)
    println(firstConnected.left!!.right!!.next!!.`val` == 6)
    println(firstConnected.right!!.left!!.next!!.`val` == 7)
    println(firstConnected.right!!.right!!.next == null)
    val secondTree = Node(1)
    secondTree.left = Node(2)
    secondTree.right = Node(3)
    secondTree.left?.left = Node(4)
    secondTree.left?.right = Node(5)
    secondTree.right?.right = Node(7)
    val secondConnected = s.connect(secondTree)
    println(secondConnected!!.next == null)
    println(secondConnected.left!!.next!!.`val` == 3)
    println(secondConnected.right!!.next == null)
    println(secondConnected.left!!.left!!.next!!.`val` == 5)
    println(secondConnected.left!!.right!!.next!!.`val` == 7)
    println(secondConnected.right!!.left == null)
    println(secondConnected.right!!.right!!.next == null)
}