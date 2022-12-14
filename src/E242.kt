private class E242 {
    fun isAnagram(s: String, t: String): Boolean {
        return s.toCharArray().sorted() == t.toCharArray().sorted()
    }

    fun isAnagram2(s: String, t: String): Boolean {
        val mapS = s.groupingBy { it }.eachCount()
        val mapT = t.groupingBy { it }.eachCount()
        return mapS == mapT
    }

    fun isAnagram3(s: String, t: String): Boolean {
        if (s.length != t.length) return false
        val map = HashMap<Char, Int>()
        for (el in s) map.merge(el, 1) { existing, _ -> existing + 1 }
        for (el in t) {
            if (!map.containsKey(el)) return false
            else if (map[el] == 1) map.remove(el)
            else map[el] = map[el]!! - 1
        }
        return map.isEmpty()
    }
}


fun main() {
    val s = E242()
    println(s.isAnagram("anagram", "nagaram"))
    println(!s.isAnagram("car", "rat"))
    println(s.isAnagram2("anagram", "nagaram"))
    println(!s.isAnagram2("car", "rat"))
    println(s.isAnagram3("anagram", "nagaram"))
    println(!s.isAnagram3("car", "rat"))
}