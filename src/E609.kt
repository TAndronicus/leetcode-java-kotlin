private class E609 {
    fun findDuplicate(paths: Array<String>): List<List<String>> {
        val fileMap = HashMap<String, MutableList<String>>()
        for (path in paths) {
            val components = path.split(" ")
            val root = components[0]
            for (file in components.drop(1)) {
                val split = file.split("(")
                val filePath = root + "/" + split[0]
                val content = split[1].substring(0, split[1].length - 1)
                if (!fileMap.containsKey(content)) fileMap[content] = mutableListOf(filePath)
                else fileMap[content]!!.add(filePath)
            }
        }
        return fileMap.values
            .filter { it.size > 1 }
    }
}


fun main() {
    val s = E609()
    println(s.findDuplicate(arrayOf("root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)")))
    println(s.findDuplicate(arrayOf("root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)")))
}