private class E858 {
    fun mirrorReflection(p: Int, q: Int): Int {
        var nom = p
        var denom = q
        while ((nom % 2 == 0) && (denom % 2 == 0)) {
            nom /= 2
            denom /= 2
        }
        return if (nom % 2 == 0) 2
        else if (denom % 2 == 0) 0
        else 1
    }
}


fun main() {
    val s = E858()
    println(s.mirrorReflection(2, 1) == 2)
    println(s.mirrorReflection(3, 1) == 1)
    println(s.mirrorReflection(3, 2) == 0)
}