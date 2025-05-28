#include <vector>

int matrixPathways(int m, int n) {
    // Base cases: Set all cells in row 0 and column 0 to 1.
    // We can do this by initializing all cells in the DP table to 1.
    std::vector<std::vector<int>> dp(m, std::vector<int>(n, 1));
    // Fill in the rest of the DP table.
    for (int r = 1; r < m; r++) {
        for (int c = 1; c < n; c++) {
            // Paths to current cell = paths from above + paths from left.
            dp[r][c] = dp[r - 1][c] + dp[r][c - 1];
        }
    }
    return dp[m - 1][n - 1];
}