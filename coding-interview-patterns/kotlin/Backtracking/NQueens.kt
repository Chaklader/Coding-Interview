fun nQueens(n: Int): Int {
    // In Kotlin, Global variable is anti-pattern
    var res = mutableListOf<Int>()
    dfs(0, mutableSetOf(), mutableSetOf(), mutableSetOf(), n, res)
    return res[0]
}

fun dfs(
        r: Int,
        diagonalsSet: MutableSet<Int>,
        antiDiagonalsSet: MutableSet<Int>,
        colsSet: MutableSet<Int>,
        n: Int,
        res: MutableList<Int>
) {
    // Termination condition: If we have reached the end of the rows,
    // we've placed all 'n' queens.
    if (r == n) {
        res[0] = res[0] + 1
        return
    }
    for (c in 0 until n) {
        val currDiagonal = r - c
        val currAntiDiagonal = r + c
        // If there are queens on the current column, diagonal or
        // anti−diagonal, skip this square.
        if (c in colsSet || currDiagonal in diagonalsSet || currAntiDiagonal in antiDiagonalsSet) {
            continue
        }
        // Place the queen by marking the current column, diagonal, and
        // anti −diagonal as occupied.
        colsSet.add(c)
        diagonalsSet.add(currDiagonal)
        antiDiagonalsSet.add(currAntiDiagonal)
        // Recursively move to the next row to continue placing queens.
        dfs(r + 1, diagonalsSet, antiDiagonalsSet, colsSet, n, res)
        // Backtrack by removing the current column, diagonal, and
        // anti −diagonal from the hash sets.
        colsSet.remove(c)
        diagonalsSet.remove(currDiagonal)
        antiDiagonalsSet.remove(currAntiDiagonal)
    }
}
