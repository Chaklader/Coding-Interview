fun matrixInfection(matrix: MutableList<MutableList<Int>>): Int {
    val dirs = listOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)
    val queue = ArrayDeque<Pair<Int, Int>>()
    var ones = 0
    var seconds = 0
    // Count the total number of uninfected cells and add each infected
    // cell to the queue to represent level 0 of the level-order
    // traversal.
    for (r in matrix.indices) {
        for (c in matrix[0].indices) {
            if (matrix[r][c] == 1) {
                ones++
            } else if (matrix[r][c] == 2) {
                queue.add(r to c)
            }
        }
    }
    // Use level-order traversal to determine how long it takes to
    // infect the uninfected cells.
    while (queue.isNotEmpty() && ones > 0) {
        // 1 second passes with each level of the matrix that's explored.
        seconds++
        for (i in 0 until queue.size) {
            val (r, c) = queue.removeFirst()
            // Infect any neighboring 1s and add them to the queue to be
            // processed in the next level.
            for ((dr, dc) in dirs) {
                val nextR = r + dr
                val nextC = c + dc
                if (isWithinBounds(nextR, nextC, matrix) && matrix[nextR][nextC] == 1) {
                    matrix[nextR][nextC] = 2
                    ones--
                    queue.add(nextR to nextC)
                }
            }
        }
    }
    // If there are still uninfected cells left, return -1. Otherwise,
    // return the time passed.
    return if (ones == 0) {
        seconds
    } else {
        -1
    }
}

fun isWithinBounds(r: Int, c: Int, matrix: List<List<Int>>): Boolean {
    return r in matrix.indices && c in matrix[0].indices
}
