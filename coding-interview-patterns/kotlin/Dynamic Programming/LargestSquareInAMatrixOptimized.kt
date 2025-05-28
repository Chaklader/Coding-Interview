fun largestSquareInAMatrixOptimized(matrix: Array<IntArray>): Int {
    if (matrix.isEmpty()) return 0
    val m = matrix.size
    val n = matrix[0].size
    var prevRow = IntArray(n)
    var maxLen = 0
    // Iterate through the matrix.
    for (i in 0 until m) {
        val currRow = IntArray(n)
        for (j in 0 until n) {
            // Base cases: if we’re in row 0 or column 0, the largest square ending
            // here has a length of 1. This can be set by using the value in the
            // input matrix.
            if (i == 0 || j == 0) {
                currRow[j] = matrix[i][j]
            } else {
                if (matrix[i][j] == 1) {
                    // curr_row[j] = 1 + min(left, top-left, top)
                    currRow[j] = 1 + minOf(currRow[j - 1], prevRow[j - 1], prevRow[j])
                }
            }
            maxLen = maxOf(maxLen, currRow[j])
        }
        // Update 'prevRow' with 'currRow' values for the next iteration.
        prevRow = currRow.copyOf()
    }
    return maxLen * maxLen
}
