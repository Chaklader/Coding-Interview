fun zeroStripingHashSets(matrix: MutableList<MutableList<Int>>) {
    if (matrix.isEmpty() || matrix[0].isEmpty()) {
        return
    }
    val m = matrix.size
    val n = matrix[0].size
    val zeroRows = hashSetOf<Int>()
    val zeroCols = hashSetOf<Int>()
    // Pass 1: Traverse through the matrix to identify the rows and
    // columns containing zeros and store their indexes in the 
    // appropriate hash sets.
    for (r in 0 until m) {
        for (c in 0 until n) {
            if (matrix[r][c] == 0) {
                zeroRows.add(r)
                zeroCols.add(c)
            }
        }
    }
    // Pass 2: Set any cell in the matrix to zero if its row index is 
    // in 'zero_rows' or its column index is in 'zero_cols'.
    for (r in 0 until m) {
        for (c in 0 until n) {
            if (r in zeroRows || c in zeroCols) {
                matrix[r][c] = 0
            }
        }
    }
}