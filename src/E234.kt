private class E234 {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun isPalindrome(head: ListNode?): Boolean {
        var pointer = head
        val deQueue = ArrayDeque<Int>()
        while (pointer != null) {
            deQueue.addLast(pointer.`val`)
            pointer = pointer.next
        }
        while (deQueue.size >= 2) {
            if (deQueue.removeFirst() != deQueue.removeLast()) return false
        }
        return true
    }

    fun assertArray(ar: IntArray): Boolean {
        val sentinel = ListNode(0)
        var pointer: ListNode = sentinel
        for (el in ar) {
            pointer.next = ListNode(el)
            pointer = pointer.next!!
        }
        return isPalindrome(sentinel.next)
    }
}


fun main() {
    val s = E234()
    println(s.assertArray(intArrayOf()))
    println(s.assertArray(intArrayOf(1)))
    println(s.assertArray(intArrayOf(1, 1)))
    println(s.assertArray(intArrayOf(1, 1, 1)))
    println(s.assertArray(intArrayOf(1, 2, 1)))
    println(s.assertArray(intArrayOf(1, 2, 2, 1)))
    println(s.assertArray(intArrayOf(1, 2, 3, 2, 1)))
    println(!s.assertArray(intArrayOf(1, 2, 3, 3, 1)))
    println(!s.assertArray(intArrayOf(1, 2, 3)))
}