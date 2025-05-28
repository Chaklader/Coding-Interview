fun verifySudokuBoard(board: List<List<Int>>): Boolean {
    // Create hash sets for each row, column, and subgrid to keep
    // track of numbers previously seen on any given row, column, or
    // subgrid.
    val rowSets: List<HashSet<Int>> = List(9) {
        hashSetOf()
    }
    val colSets: List<HashSet<Int>> = List(9) {
        hashSetOf()
    }
    val subgridSets: List<List<HashSet<Int>>> = List(3) {
        List(3) {
            hashSetOf()
        }
    }
    for (r in 0 until 9) {
        for (c in 0 until 9) {
            val num = board[r][c]
            if (num == 0) {
                continue
            }
            // Check if 'num' has been seen in the current row,
            // column, or subgrid.
            if (rowSets[r].contains(num)) {
                return false
            }
            if (colSets[c].contains(num)) {
                return false
            }
            if (subgridSets[r / 3][c / 3].contains(num)) {
                return false
            }
            // If we passed the above checks, mark this value as seen 
            // by adding it to its corresponding hash sets.
            rowSets[r].add(num)
            colSets[c].add(num)
            subgridSets[r / 3][c / 3].add(num)
        }
    }
    return true
}