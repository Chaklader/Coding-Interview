#include <vector>
#include <algorithm>

int knapsackOptimized(int cap, std::vector<int>& weights, std::vector<int>& values) {
    int n = values.size();
    // Initialize 'prevRow' as the DP values of the row below the 
    // current row.
    std::vector<int> prevRow(cap + 1, 0);
    for (int i = n - 1; i >= 0; i--) {
        // Set the first cell of the 'currRow' to 0 to set the base 
        // case for this row. This is done by initializing the entire 
        // row to 0.
        std::vector<int> currRow(cap + 1, 0);
        for (int c = 1; c <= cap; c++) {
            // If item 'i' fits in the current knapsack capacity, the
            // maximum value at 'currRow[c]' is the largest of either:
            // 1. The maximum value if we include item 'i'.
            // 2. The maximum value if we exclude item 'i'.
            if (weights[i] <= c) {
                currRow[c] = std::max(values[i] + prevRow[c - weights[i]], prevRow[c]);
            }
            // If item 'i' doesn't fit, we exclude it.
            else {
                currRow[c] = prevRow[c];
            }
        }
        // Set 'prevRow' to 'currRow' values for the next iteration.
        prevRow = currRow;
    }
    return prevRow[cap];
}