import java.math.BigInteger

private class E96 {
    fun numTrees1(n: Int): Int {
        return if (n == 0) 1
        else if (n == 1) 1
        else {
            var sum = 0
            for (i in 0 until n) {
                sum += numTrees1(i) * numTrees1(n - i - 1)
            }
            sum
        }
    }

    fun numTrees2(n: Int): Int {
        var nom = BigInteger.ONE
        var denom = BigInteger.ONE
        for (i in 2..n) {
            nom *= (BigInteger.valueOf(n.toLong() + i))
            denom *= BigInteger.valueOf(i.toLong())
        }
        return nom.divide(denom).toInt()
    }

    fun numTrees3(n: Int): Int {
        return if (n == 1) 1
        else if (n == 2) 2
        else if (n == 3) 5
        else if (n == 4) 14
        else if (n == 5) 42
        else if (n == 6) 132
        else if (n == 7) 429
        else if (n == 8) 1430
        else if (n == 9) 4862
        else if (n == 10) 16796
        else if (n == 11) 58786
        else if (n == 12) 208012
        else if (n == 13) 742900
        else if (n == 14) 2674440
        else if (n == 15) 9694845
        else if (n == 16) 35357670
        else if (n == 17) 129644790
        else if (n == 18) 477638700
        else if (n == 19) 1767263190
        else 0
    }

    fun numTrees4(n: Int): Int {
        return if (n % 2 == 0) {
            if (n % 4 == 0) {
                if (n > 10) {
                    if (n == 12) 208012
                    else 35357670
                } else {
                    if (n == 4) 14
                    else 1430
                }
            } else {
                if (n == 10) 16796
                else if (n < 10) {
                    if (n == 2) 2
                    else 132
                } else {
                    if (n == 14) 2674440
                    else 477638700
                }
            }
        } else {
            if (n % 3 == 0) {
                if (n == 3) 5
                else if (n == 9) 4862
                else 9694845
            } else if (n % 3 == 1) {
                if (n > 10) {
                    if (n == 13) 742900
                    else 1767263190
                } else {
                    if (n == 1) 1
                    else 429
                }
            } else {
                if (n == 5) 42
                else if (n == 11) 58786
                else 129644790
            }
        }
    }
}


fun main() {
    val s = E96()
    println(s.numTrees1(1) == 1)
    println(s.numTrees1(2) == 2)
    println(s.numTrees1(3) == 5)
    println(s.numTrees1(4) == 14)
    println(s.numTrees1(5) == 42)
    println(s.numTrees1(6) == 132)
    println(s.numTrees1(7) == 429)
    println(s.numTrees1(8) == 1430)
    println(s.numTrees1(9) == 4862)
    println(s.numTrees1(10) == 16796)
    println(s.numTrees2(1) == 1)
    println(s.numTrees2(2) == 2)
    println(s.numTrees2(3) == 5)
    println(s.numTrees2(4) == 14)
    println(s.numTrees2(5) == 42)
    println(s.numTrees2(6) == 132)
    println(s.numTrees2(7) == 429)
    println(s.numTrees2(8) == 1430)
    println(s.numTrees2(9) == 4862)
    println(s.numTrees2(10) == 16796)
    println(s.numTrees3(1) == 1)
    println(s.numTrees3(2) == 2)
    println(s.numTrees3(3) == 5)
    println(s.numTrees3(4) == 14)
    println(s.numTrees3(5) == 42)
    println(s.numTrees3(6) == 132)
    println(s.numTrees3(7) == 429)
    println(s.numTrees3(8) == 1430)
    println(s.numTrees3(9) == 4862)
    println(s.numTrees3(10) == 16796)
    println(s.numTrees4(1) == 1)
    println(s.numTrees4(2) == 2)
    println(s.numTrees4(3) == 5)
    println(s.numTrees4(4) == 14)
    println(s.numTrees4(5) == 42)
    println(s.numTrees4(6) == 132)
    println(s.numTrees4(7) == 429)
    println(s.numTrees4(8) == 1430)
    println(s.numTrees4(9) == 4862)
    println(s.numTrees4(10) == 16796)
}