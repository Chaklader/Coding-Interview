def longest_common_subsequence(s1: str, s2: str) -> int:
    # Base case: Set the last row and last column to 0 by
    # initializing the entire DP table with 0s.
    dp = [[0] * (len(s2) + 1) for _ in range(len(s1) + 1)]
    # Populate the DP table.
    for i in range(len(s1) - 1, -1, -1):
        for j in range(len(s2) - 1, -1, -1):
            # If the characters match, the length of the LCS at
            # 'dp[i][j]' is  1 + the LCS length of the remaining
            # substrings.
            if s1[i] == s2[j]:
                dp[i][j] = 1 + dp[i + 1][j + 1]
            # If the characters don't match, the LCS length at
            # 'dp[i][j]' can be found by either:
            # 1. Excluding the current character of s1.
            # 2. Excluding the current character of s2.
            else:
                dp[i][j] = max(dp[i + 1][j], dp[i][j + 1])
    return dp[0][0]
