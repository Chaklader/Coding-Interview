fun spiralMatrix(matrix: List<List<Int>>): List<Int> {
    if (matrix.isEmpty()) {
        return emptyList()
    }
    val result = mutableListOf<Int>()
    // Initialize the matrix boundaries.
    var top = 0
    var bottom = matrix.size - 1
    var left = 0
    var right = matrix[0].size - 1
    // Traverse the matrix in spiral order.
    while (top <= bottom && left <= right) {
        // Move from left to right along the top boundary.
        for (i in left..right) {
            result.add(matrix[top][i])
        }
        top++
        // Move from top to bottom along the right boundary.
        for (i in top..bottom) {
            result.add(matrix[i][right])
        }
        right--
        // Check that the bottom boundary hasn't passed the top boundary
        // before moving from right to left along the bottom boundary.
        if (top <= bottom) {
            for (i in right downTo left) {
                result.add(matrix[bottom][i])
            }
            bottom--
        }
        // Check that the left boundary hasn't passed the right boundary
        // before moving from bottom to top along the left boundary.
        if (left <= right) {
            for (i in bottom downTo top) {
                result.add(matrix[i][left])
            }
            left++
        }
    }
    return result
}
