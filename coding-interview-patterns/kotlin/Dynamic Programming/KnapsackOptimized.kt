fun knapsackOptimized(cap: Int, weights: List<Int>, values: List<Int>): Int {
    val n = values.size
    // Initialize 'prevRow' as the DP values of the row below the
    // current row.
    var prevRow = IntArray(cap + 1)
    for (i in n - 1 downTo 0) {
        // Set the first cell of the 'currRow' to 0 to set the base
        // case for this row. This is done by initializing the entire
        // row to 0.
        val currRow = IntArray(cap + 1)
        for (c in 1..cap) {
            // If item 'i' fits in the current knapsack capacity, the
            // maximum value at 'currRow[c]' is the largest of either:
            // 1. The maximum value if we include item 'i'.
            // 2. The maximum value if we exclude item 'i'.
            if (weights[i] <= c) {
                currRow[c] = Math.max(values[i] + prevRow[c - weights[i]], prevRow[c])
            } else {
                // If it doesn't fit, we have to exclude it.
                currRow[c] = prevRow[c]
            }
        }
        // Set 'prevRow' to 'currRow' values for the next iteration.
        prevRow = currRow
    }
    return prevRow[cap]
}
