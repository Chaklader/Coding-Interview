fun countIslands(matrix: MutableList<MutableList<Int>>): Int {
    if (matrix.isEmpty()) {
        return 0
    }
    var count = 0
    for (r in matrix.indices) {
        for (c in matrix[0].indices) {
            // If a land cell is found, perform DFS to explore the full
            // island, and include this island in our count.
            if (matrix[r][c] == 1) {
                dfs(r, c, matrix)
                count++
            }
        }
    }
    return count
}

fun dfs(r: Int, c: Int, matrix: MutableList<MutableList<Int>>) {
    // Mark the current land cell as visited.
    matrix[r][c] = -1
    // Define direction vectors for up, down, left, and right.
    val dirs = listOf(Pair(-1, 0), Pair(1, 0), Pair(0, -1), Pair(0, 1))
    // Recursively call DFS on each neighboring land cell to continue
    // exploring this island.
    for (d in dirs) {
        val nextR = r + d.first
        val nextC = c + d.second
        if (isWithinBounds(nextR, nextC, matrix) && matrix[nextR][nextC] == 1) {
            dfs(nextR, nextC, matrix)
        }
    }
}

fun isWithinBounds(r: Int, c: Int, matrix: MutableList<MutableList<Int>>): Boolean {
    return r in matrix.indices && c in matrix[0].indices
}
