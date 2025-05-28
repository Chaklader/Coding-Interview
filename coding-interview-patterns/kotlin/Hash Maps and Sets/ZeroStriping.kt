fun zeroStriping(matrix: MutableList<MutableList<Int>>) {
    if (matrix.isEmpty() || matrix[0].isEmpty()) {
        return
    }
    val m = matrix.size
    val n = matrix[0].size
    // Check if the first row initially contains a zero.
    var firstRowHasZero = false
    for (c in 0 until n) {
        if (matrix[0][c] == 0) {
            firstRowHasZero = true
            break
        }
    }
    // Check if the first column initially contains a zero.
    var firstColHasZero = false
    for (r in 0 until m) {
        if (matrix[r][0] == 0) {
            firstColHasZero = true
            break
        }
    }
    // Use the first row and column as markers. If an element in the 
    // submatrix is zero, mark its corresponding row and column in the 
    // first row and column as 0.
    for (r in 1 until m) {
        for (c in 1 until n) {
            if (matrix[r][c] == 0) {
                matrix[0][c] = 0
                matrix[r][0] = 0
            }
        }
    }
    // Update the submatrix using the markers in the first row and 
    // column.
    for (r in 1 until m) {
        for (c in 1 until n) {
            if (matrix[0][c] == 0 || matrix[r][0] == 0) {
                matrix[r][c] = 0
            }
        }
    }
    // If the first row had a zero initially, set all elements in the 
    // first row to zero.
    if (firstRowHasZero) {
        for (c in 0 until n) {
            matrix[0][c] = 0
        }
    }
    // If the first column had a zero initially, set all elements in 
    // the first column to zero.
    if (firstColHasZero) {
        for (r in 0 until m) {
            matrix[r][0] = 0
        }
    }
}