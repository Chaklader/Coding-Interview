#include <vector>
#include <algorithm>

int knapsack(int cap, std::vector<int>& weights, std::vector<int>& values) {
    int n = values.size();
    // Base case: Set the first column and last row to 0 by
    // initializing the entire DP table to 0.
    std::vector<std::vector<int>> dp(n + 1, std::vector<int>(cap + 1, 0));
    // Populate the DP table.
    for (int i = n - 1; i >= 0; i--) {
        for (int c = 1; c <= cap; c++) {
            // If the item 'i' fits in the current knapsack capacity, 
            // the maximum value at 'dp[i][c]' is the largest of either:
            // 1. The maximum value if we include item 'i'.
            // 2. The maximum value if we exclude item 'i'.
            if (weights[i] <= c) {
                dp[i][c] = std::max(values[i] + dp[i + 1][c - weights[i]], dp[i + 1][c]);
            }
            // If it doesn't fit, we have to exclude it.
            else {
                dp[i][c] = dp[i + 1][c];
            }
        }
    }
    return dp[0][cap];
}