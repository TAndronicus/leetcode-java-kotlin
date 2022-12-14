private class E168 {
    fun convertToTitle(columnNumber: Int): String {
        val name = StringBuilder()
        var num: Int = columnNumber - 1
        while (num >= 0) {
            name.append(((num % 26) + 65).toChar())
            num = (num / 26) - 1
        }
        return name.reverse().toString()
    }
}


fun main() {
    val s = E168()
    println(s.convertToTitle(1) == "A")
    println(s.convertToTitle(2) == "B")
    println(s.convertToTitle(27) == "AA")
    println(s.convertToTitle(701) == "ZY")
    println(s.convertToTitle(703) == "AAA")
}