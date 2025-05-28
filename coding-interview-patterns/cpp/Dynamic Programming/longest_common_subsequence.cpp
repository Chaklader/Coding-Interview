#include <vector>
#include <string>
#include <algorithm>

int longestCommonSubsequence(std::string& s1, std::string& s2) {
    // Base case: Set the last row and last column to 0 by
    // initializing the entire DP table with 0s.
    std::vector<std::vector<int>> dp(s1.length() + 1, std::vector<int>(s2.length() + 1, 0));
    // Populate the DP table.
    for (int i = s1.length() - 1; i >= 0; i--) {
        for (int j = s2.length() - 1; j >= 0; j--) {
            // If the characters match, the length of the LCS at
            // 'dp[i][j]' is 1 + the LCS length of the remaining
            // substrings.
            if (s1[i] == s2[j]) {
                dp[i][j] = 1 + dp[i + 1][j + 1];
            }
            // If the characters don't match, the LCS length at
            // 'dp[i][j]' can be found by either:
            // 1. Excluding the current character of s1.
            // 2. Excluding the current character of s2.
            else {
                dp[i][j] = std::max(dp[i + 1][j], dp[i][j + 1]);
            }
        }
    }
    return dp[0][0];
}