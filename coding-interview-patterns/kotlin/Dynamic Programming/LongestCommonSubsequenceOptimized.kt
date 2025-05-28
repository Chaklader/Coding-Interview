fun longestCommonSubsequenceOptimized(s1: String, s2: String): Int {
    // Initialize 'prevRow' as the DP values of the last row.
    var prevRow = IntArray(s2.length + 1)
    for (i in s1.length - 1 downTo 0) {
        // Set the last cell of 'currRow' to 0 to set the base case for
        // this row. This is done by initializing the entire row to 0.
        val currRow = IntArray(s2.length + 1)
        for (j in s2.length - 1 downTo 0) {
            // If the characters match, the length of the LCS at
            // 'currRow[j]' is 1 + the LCS length of the remaining
            // substrings ('prevRow[j + 1]').
            if (s1[i] == s2[j]) {
                currRow[j] = 1 + prevRow[j + 1]
            } else {
                // If the characters don't match, the LCS length at
                // 'currRow[j]' can be found by either:
                // 1. Excluding the current character of s1 ('prevRow[j]').
                // 2. Excluding the current character of s2 ('currRow[j + 1]').
                currRow[j] = maxOf(prevRow[j], currRow[j + 1])
            }
        }
        // Update 'prevRow' with 'currRow' values for the next iteration.
        prevRow = currRow
    }
    return prevRow[0]
}
