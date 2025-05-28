fun longestCommonSubsequence(s1: String, s2: String): Int {
    // Base case: Set the last row and last column to 0 by
    // initializing the entire DP table with 0s.
    val dp = Array(s1.length + 1) { IntArray(s2.length + 1) }
    // Populate the DP table.
    for (i in s1.length - 1 downTo 0) {
        for (j in s2.length - 1 downTo 0) {
            // If the characters match, the length of the LCS at
            // 'dp[i][j]' is 1 + the LCS length of the remaining
            // substrings.
            if (s1[i] == s2[j]) {
                dp[i][j] = 1 + dp[i + 1][j + 1]
            } else {
                // If the characters don't match, the LCS length at
                // 'dp[i][j]' can be found by either:
                // 1. Excluding the current character of s1.
                // 2. Excluding the current character of s2.
                dp[i][j] = maxOf(dp[i + 1][j], dp[i][j + 1])
            }
        }
    }
    return dp[0][0]
}
