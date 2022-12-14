private class E869 {
    fun reorderedPowerOf2(n: Int): Boolean {
        val digits = HashMap<Char, Int>()
        val asString = n.toString()
        for (ch in asString.toCharArray()) digits.merge(ch, 1) { existing, _ -> existing + 1 }
        var power = 0.0
        while (true) {
            val toString = Math.pow(2.0, power).toInt().toString()
            if (toString.length > asString.length) break
            val powerAsStr = toString.toCharArray().groupBy { it }.mapValues { it.value.size }
            if (toString.length == asString.length && powerAsStr.all { it.value == digits[it.key] }) return true
            power += 1
        }
        return false
    }
}


fun main() {
    val s = E869()
    println(s.reorderedPowerOf2(1))
    println(!s.reorderedPowerOf2(10))
    println(!s.reorderedPowerOf2(414))
    println(s.reorderedPowerOf2(218))
}