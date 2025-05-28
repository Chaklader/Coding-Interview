fun largestSquareInAMatrix(matrix: List<List<Int>>): Int {
    if (matrix.isEmpty()) {
        return 0
    }
    val m = matrix.size
    val n = matrix[0].size
    val dp = Array(m) { IntArray(n) }
    var maxLen = 0
    // Base case: If a cell in row 0 is 1, the largest square ending there has a
    // length of 1.
    for (j in 0 until n) {
        if (matrix[0][j] == 1) {
            dp[0][j] = 1
            maxLen = 1
        }
    }
    // Base case: If a cell in column 0 is 1, the largest square ending there has
    // a length of 1.
    for (i in 0 until m) {
        if (matrix[i][0] == 1) {
            dp[i][0] = 1
            maxLen = 1
        }
    }
    // Populate the rest of the DP table.
    for (i in 1 until m) {
        for (j in 1 until n) {
            if (matrix[i][j] == 1) {
                // The length of the largest square ending here is determined by
                // the smallest square ending at the neighboring cells (left,
                // top-left, top), plus 1 to include this cell.
                dp[i][j] = 1 + minOf(dp[i - 1][j], dp[i - 1][j - 1], dp[i][j - 1])
            }
            maxLen = maxOf(maxLen, dp[i][j])
        }
    }
    return maxLen * maxLen
}
