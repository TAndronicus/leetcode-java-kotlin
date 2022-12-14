private class E171 {
    fun convertToTitle(columnNumber: Int): String {
        val name = StringBuilder()
        var num: Int = columnNumber - 1
        while (num >= 0) {
            name.append(((num % 26) + 65).toChar())
            num = (num / 26) - 1
        }
        return name.reverse().toString()
    }

    fun titleToNumber(columnTitle: String): Int {
        var sum = 0
        for (ch in columnTitle.toCharArray()) {
            sum = sum * 26 + ch.code - 64
        }
        return sum
    }
}


fun main() {
    val s = E171()
    println(s.convertToTitle(1) == "A")
    println(s.convertToTitle(2) == "B")
    println(s.convertToTitle(27) == "AA")
    println(s.convertToTitle(701) == "ZY")
    println(s.convertToTitle(703) == "AAA")
    println(s.titleToNumber("A") == 1)
    println(s.titleToNumber("B") == 2)
    println(s.titleToNumber("AA") == 27)
    println(s.titleToNumber("ZY") == 701)
    println(s.titleToNumber("AAA") == 703)
}