private class E92 {
    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
        if (left == right) return head
        val slice: ListNode = ListNode(0)
        var slicePointer: ListNode? = slice
        var leftList: ListNode? = ListNode(0)
        var rightList: ListNode? = ListNode(0)
        var pointer: ListNode? = head
        for (counter in 1..(right + 1)) {
            if (counter == left - 1) leftList = pointer
            else if (counter in left..right) {
                slicePointer?.`val` = pointer?.`val`!!
                val tmp = ListNode(0)
                tmp.next = slicePointer
                slicePointer = tmp
            } else if (counter == right + 1) rightList = pointer
            pointer = pointer?.next
        }
        if (left > 1) leftList!!.next = slicePointer?.next
        slice?.next = rightList
        return if (left > 1) head else slicePointer?.next
    }
}

private class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

private fun fromArray(array: IntArray): ListNode? {
    val sentinel = ListNode(0)
    var pointer: ListNode? = sentinel
    for (el in array) {
        pointer?.next = ListNode(el)
        pointer = pointer?.next
    }
    return sentinel.next
}

private fun toArray(listNode: ListNode?): IntArray {
    val res = mutableListOf<Int>()
    var pointer = listNode
    while (pointer != null) {
        res.add(pointer.`val`)
        pointer = pointer.next
    }
    return res.toIntArray()
}

fun main() {
    val s = E92()
    println(toArray(s.reverseBetween(fromArray(intArrayOf(1, 2, 3, 4, 5)), 1, 3)).contentEquals(intArrayOf(3, 2, 1, 4, 5)))
    println(toArray(s.reverseBetween(fromArray(intArrayOf(1, 2, 3, 4, 5)), 2, 4)).contentEquals(intArrayOf(1, 4, 3, 2, 5)))
    println(toArray(s.reverseBetween(fromArray(intArrayOf(1, 2, 3, 4, 5)), 3, 5)).contentEquals(intArrayOf(1, 2, 5, 4, 3)))
    println(toArray(s.reverseBetween(fromArray(intArrayOf(1, 2, 3, 4, 5)), 1, 5)).contentEquals(intArrayOf(5, 4, 3, 2, 1)))
    println(toArray(s.reverseBetween(fromArray(intArrayOf(1, 2, 3, 4, 5)), 1, 1)).contentEquals(intArrayOf(1, 2, 3, 4, 5)))
    println(toArray(s.reverseBetween(fromArray(intArrayOf(5)), 1, 1)).contentEquals(intArrayOf(5)))
}