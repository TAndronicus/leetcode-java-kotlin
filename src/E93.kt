private class E93 {
    fun restoreIpAddresses(s: String): List<String> {
        val result = mutableListOf<String>()
        restoreIpAddresses(s, listOf(), result)
        return result
    }

    private fun restoreIpAddresses(remaining: String, path: List<String>, result: MutableList<String>) {
        if (path.size < 4 && remaining.isNotEmpty()) {
            val first = remaining.substring(0, 1).toInt()
            restoreIpAddresses(remaining.substring(1), path.plus(remaining.substring(0, 1)), result)
            if (first != 0) {
                if (remaining.length > 1) restoreIpAddresses(remaining.substring(2), path.plus(remaining.substring(0, 2)), result)
                if (remaining.length > 2 && remaining.substring(0, 3).toInt() < 256) restoreIpAddresses(remaining.substring(3), path.plus(remaining.substring(0, 3)), result)
            }
        } else if (path.size == 4 && remaining.isEmpty()) result.add(path.joinToString(separator = "."))
    }
}


fun main() {
    val s = E93()
    println(s.restoreIpAddresses("25525511135") == listOf("255.255.11.135", "255.255.111.35"))
    println(s.restoreIpAddresses("0000") == listOf("0.0.0.0"))
    println(s.restoreIpAddresses("101023") == listOf("1.0.10.23", "1.0.102.3", "10.1.0.23", "10.10.2.3", "101.0.2.3"))
}