fun knapsack(cap: Int, weights: List<Int>, values: List<Int>): Int {
    val n = values.size
    // Base case: Set the first column and last row to 0 by
    // initializing the entire DP table to 0.
    val dp = Array(n + 1) { IntArray(cap + 1) }
    // Populate the DP table.
    for (i in n - 1 downTo 0) {
        for (c in 1..cap) {
            // If the item 'i' fits in the current knapsack capacity,
            // the maximum value at 'dp[i][c]' is the largest of either:
            // 1. The maximum value if we include item 'i'.
            // 2. The maximum value if we exclude item 'i'.
            if (weights[i] <= c) {
                dp[i][c] = Math.max(values[i] + dp[i + 1][c - weights[i]], dp[i + 1][c])
            } else {
                // If it doesn't fit, we have to exclude it.
                dp[i][c] = dp[i + 1][c]
            }
        }
    }
    return dp[0][cap]
}
