private class E130 {
    fun solve(board: Array<CharArray>): Unit {
        if (board.size < 3 || board[0].size < 3) return
        val queue = ArrayDeque<Pair<Int, Int>>()
        val bordered = mutableSetOf<Pair<Int, Int>>()
        for (i in 1 until board.size - 1) {
            if (board[i][0] == 'O') queue.add(Pair(i, 0))
            if (board[i][board[0].size - 1] == 'O') queue.add(Pair(i, board[0].size - 1))
        }
        for (i in 1 until board[0].size - 1) {
            if (board[0][i] == 'O') queue.add(Pair(0, i))
            if (board[board.size - 1][i] == 'O') queue.add(Pair(board.size - 1, i))
        }
        while (queue.isNotEmpty()) {
            val (left, right) = queue.removeFirst()
            if (left - 1 > 0 && board[left - 1][right] == 'O' && !bordered.contains(Pair(left - 1, right))) {
                queue.add(Pair(left - 1, right))
                bordered.add(Pair(left - 1, right))
            }
            if (left + 1 < board.size - 1 && board[left + 1][right] == 'O' && !bordered.contains(Pair(left + 1, right))) {
                queue.add(Pair(left + 1, right))
                bordered.add(Pair(left + 1, right))
            }
            if (right - 1 > 0 && board[left][right - 1] == 'O' && !bordered.contains(Pair(left, right - 1))) {
                queue.add(Pair(left, right - 1))
                bordered.add(Pair(left, right - 1))
            }
            if (right + 1 < board[0].size - 1 && board[left][right + 1] == 'O' && !bordered.contains(Pair(left, right + 1))) {
                queue.add(Pair(left, right + 1))
                bordered.add(Pair(left, right + 1))
            }
        }
        for (i in 1 until board.size - 1) {
            for (j in 1 until board[0].size - 1) {
                if (board[i][j] == 'O' && !bordered.contains(Pair(i, j))) board[i][j] = 'X'
            }
        }
    }
}


fun main() {
    val s = E130()
    val board1 = arrayOf(
        charArrayOf('X', 'X', 'X', 'X'),
        charArrayOf('X', 'O', 'O', 'X'),
        charArrayOf('X', 'X', 'O', 'X'),
        charArrayOf('X', 'O', 'X', 'X')
    )
    s.solve(board1)
    println(board1[1][1] == 'X')
    println(board1[1][2] == 'X')
    println(board1[2][2] == 'X')
    println(board1[3][1] == 'O')
    val board2 = arrayOf(
        charArrayOf('X', 'X', 'X', 'X'),
        charArrayOf('X', 'O', 'O', 'X'),
        charArrayOf('X', 'O', 'O', 'X'),
        charArrayOf('X', 'O', 'X', 'X')
    )
    s.solve(board2)
    println(board2[1][1] == 'O')
    println(board2[1][2] == 'O')
    println(board2[2][2] == 'O')
    println(board2[3][1] == 'O')
    val board3 = arrayOf(charArrayOf('X'))
    s.solve(board3)
    println(board3[0][0] == 'X')
    val board4 = arrayOf(
        charArrayOf('O', 'O', 'O'),
        charArrayOf('O', 'O', 'O'),
        charArrayOf('O', 'O', 'O')
    )
    s.solve(board4)
    for (row in board4) {
        for (c in row) println(c == 'O')
    }
    val board5 = arrayOf(
        charArrayOf('X', 'O', 'X', 'X'),
        charArrayOf('O', 'X', 'O', 'X'),
        charArrayOf('X', 'O', 'X', 'O'),
        charArrayOf('O', 'X', 'O', 'X')
    )
    val expected5 = arrayOf(
        charArrayOf('X', 'O', 'X', 'X'),
        charArrayOf('O', 'X', 'X', 'X'),
        charArrayOf('X', 'X', 'X', 'O'),
        charArrayOf('O', 'X', 'O', 'X')
    )
    s.solve(board5)
    println(board5.zip(expected5).map { it.first.contentEquals(it.second) }.reduce { acc, b -> acc && b })
    val board6 = arrayOf(
        charArrayOf('X', 'O', 'X', 'X', 'X', 'O'),
        charArrayOf('O', 'X', 'O', 'X', 'O', 'X'),
        charArrayOf('X', 'O', 'X', 'O', 'X', 'X'),
        charArrayOf('O', 'X', 'O', 'X', 'O', 'X')
    )
    val expected6 = arrayOf(
        charArrayOf('X', 'O', 'X', 'X', 'X', 'O'),
        charArrayOf('O', 'X', 'X', 'X', 'X', 'X'),
        charArrayOf('X', 'X', 'X', 'X', 'X', 'X'),
        charArrayOf('O', 'X', 'O', 'X', 'O', 'X')
    )
    s.solve(board6)
    println(board6.zip(expected6).map { it.first.contentEquals(it.second) }.reduce { acc, b -> acc && b })
}