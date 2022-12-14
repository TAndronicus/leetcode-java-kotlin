private class E659 {
    fun isPossible(nums: IntArray): Boolean {
        val singleElement = HashMap<Int, Int>() // how many single-valued subsequences end with an index
        val doubleElement = HashMap<Int, Int>() // how many double-valued subsequences end with an index
        val threeOrMoreElements = HashMap<Int, Int>() // how many subsequences with at least 3 values end with an index
        for (el in nums) {
            if (singleElement.containsKey(el - 1)) {
                // move the element to double-valued
                decreaseOrRemove(singleElement, el - 1)
                doubleElement.merge(el, 1) { existing, _ -> existing + 1 }
            } else if (doubleElement.containsKey(el - 1)) {
                // move the element to full subsequences
                decreaseOrRemove(doubleElement, el - 1)
                threeOrMoreElements.merge(el, 1) { existing, _ -> existing + 1 }
            } else if (threeOrMoreElements.containsKey(el - 1)) {
                // append to existing
                decreaseOrRemove(threeOrMoreElements, el - 1)
                threeOrMoreElements.merge(el, 1) { existing, _ -> existing + 1 }
            } else {
                // start new subsequence
                singleElement.merge(el, 1) { existing, _ -> existing + 1 }
            }
            if (singleElement.containsKey(el - 2) || doubleElement.containsKey(el - 2)) return false // check for orphaned values
        }
        return singleElement.isEmpty() && doubleElement.isEmpty() // check that there are no 1 and 2-valued subsequences
    }

    private fun decreaseOrRemove(map: HashMap<Int, Int>, index: Int) {
        if (map[index] == 1) map.remove(index)
        else map[index] = map[index]!! - 1
    }
}


fun main() {
    val s = E659()
    println(s.isPossible(intArrayOf(1, 2, 3, 3, 4, 5)))
    println(s.isPossible(intArrayOf(1, 2, 3, 3, 4, 4, 5, 5)))
    println(!s.isPossible(intArrayOf(1, 2, 3, 4, 4, 5)))
    println(s.isPossible(intArrayOf(1, 2, 3, 5, 6, 7)))
    println(s.isPossible(intArrayOf(1, 2, 3, 4, 6, 7, 8)))
    println(s.isPossible(intArrayOf(1, 2, 3, 3, 4, 5)))
    println(s.isPossible(intArrayOf(1, 2, 3, 3, 4, 4, 5)))
    println(!s.isPossible(intArrayOf(1, 2, 3, 3, 4, 4)))
    println(!s.isPossible(intArrayOf(1, 2, 3, 3, 4, 4)))
    println(!s.isPossible(intArrayOf(1, 2, 3, 5, 6)))
    println(!s.isPossible(intArrayOf(1, 2, 3, 3, 3, 4, 5)))
}