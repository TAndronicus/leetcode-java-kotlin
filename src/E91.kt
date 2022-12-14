private class E91 {
    fun numDecodings(s: String): Int {
        return if (s.isEmpty()) 1
        else if (s.substring(0, 1).toInt() == 0) 0
        else if (s.length == 1 || s.substring(0, 2).toInt() > 26) numDecodings(s.substring(1))
        else numDecodings(s.substring(1)) + numDecodings(s.substring(2))
    }

    fun numDecodingsStackSafe(s: String): Int {
        if (s.first() == '0') return 0
        if (s.length == 1) return 1
        var subtracted: Int = 0
        var index = 0
        while (index < s.length - 2) {
            val sub = s.substring(index, index + 2)
            if (sub.first() == '0') return 0
            else if (sub.toInt() > 26 && sub.last() == '0') return 0
            else if (sub.toInt() > 26) {
                subtracted++
                index++
            } else if (sub.last() == '0') {
                subtracted += 2
                index += 2
            } else {
                index++
            }
        }
        if (index == s.length - 1 && s.last() == '0') return 0
        val diff = index - subtracted + 1
        if (diff < 2) return 1
        val res = IntArray(diff)
        res[0] = 1
        res[1] = 2
        for (i in 2..(diff - 1)) {
            res[i] = res[i - 1] + res[i - 2]
        }
        return res.last()
    }
}

fun main() {
    val s = E91()
//    println(s.numDecodings("1") == 1)
//    println(s.numDecodings("11") == 2)
//    println(s.numDecodings("111") == 3)
//    println(s.numDecodings("1111") == 5)
//    println(s.numDecodings("11111") == 8)
//    println(s.numDecodings("111111") == 13)
//    println(s.numDecodings("226") == 3)
//    println(s.numDecodings("227") == 2)
//    println(s.numDecodingsStackSafe("1") == 1)
//    println(s.numDecodingsStackSafe("11") == 2)
    println(s.numDecodingsStackSafe("11"))
    println(s.numDecodingsStackSafe("111") == 3)
    println(s.numDecodingsStackSafe("1111") == 5)
    println(s.numDecodingsStackSafe("11111") == 8)
    println(s.numDecodingsStackSafe("111111") == 13)
    println(s.numDecodingsStackSafe("226") == 3)
    println(s.numDecodingsStackSafe("227") == 2)
    println(s.numDecodingsStackSafe("06") == 0)
    println(s.numDecodingsStackSafe("60") == 0)
    println(s.numDecodingsStackSafe("160") == 0)
    println(s.numDecodingsStackSafe("1610") == 2)
    println(s.numDecodingsStackSafe("161010") == 2)
    println(s.numDecodingsStackSafe("1610101") == 2)
    println(s.numDecodingsStackSafe("10") == 1)
    println(s.numDecodingsStackSafe("20".repeat(50)) == 1)
}