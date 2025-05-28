fun longestIncreasingPath(matrix: List<List<Int>>): Int {
    if (matrix.isEmpty()) {
        return 0
    }
    var res = 0
    val m = matrix.size
    val n = matrix[0].size
    val memo = Array(m) { IntArray(n) }
    // Find the longest increasing path starting at each cell. The
    // maximum of these is equal to the overall longest increasing
    // path.
    for (r in matrix.indices) {
        for (c in matrix[0].indices) {
            res = maxOf(res, dfs(r, c, matrix, memo))
        }
    }
    return res
}

fun dfs(r: Int, c: Int, matrix: List<List<Int>>, memo: Array<IntArray>): Int {
    if (memo[r][c] != 0) {
        return memo[r][c]
    }
    var maxPath = 1
    val dirs = listOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)
    // The longest path starting at the current cell is equal to the
    // longest path of its larger neighboring cells, plus 1.
    for (d in dirs) {
        val (nextR, nextC) = r + d.first to c + d.second
        if (isWithinBounds(nextR, nextC, matrix) && matrix[nextR][nextC] > matrix[r][c]) {
            maxPath = maxOf(maxPath, 1 + dfs(nextR, nextC, matrix, memo))
        }
    }
    memo[r][c] = maxPath
    return maxPath
}

fun isWithinBounds(r: Int, c: Int, matrix: List<List<Int>>): Boolean {
    return r in matrix.indices && c in matrix[0].indices
}
