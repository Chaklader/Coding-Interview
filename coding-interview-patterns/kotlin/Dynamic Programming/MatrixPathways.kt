fun matrixPathways(m: Int, n: Int): Int {
    // Base cases: Set all cells in row 0 and column 0 to 1. We can
    // do this by initializing all cells in the DP table to 1.
    val dp = Array(m) { IntArray(n) { 1 } }
    // Fill in the rest of the DP table.
    for (r in 1 until m) {
        for (c in 1 until n) {
            // Paths to current cell = paths from above + paths from
            // left.
            dp[r][c] = dp[r - 1][c] + dp[r][c - 1]
        }
    }
    return dp[m - 1][n - 1]
}
