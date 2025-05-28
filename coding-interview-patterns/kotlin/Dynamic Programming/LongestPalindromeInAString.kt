fun longestPalindromeInAString(s: String): String {
    val n = s.length
    if (n == 0) {
        return ""
    }
    val dp = Array(n) { BooleanArray(n) }
    var maxLen = 1
    var startIndex = 0
    // Base case: a single character is always a palindrome.
    for (i in 0 until n) {
        dp[i][i] = true
    }
    // Base case: a substring of length two is a palindrome if both
    // characters are the same.
    for (i in 0 until n - 1) {
        if (s[i] == s[i + 1]) {
            dp[i][i + 1] = true
            maxLen = 2
            startIndex = i
        }
    }
    // Find palindromic substrings of length 3 or greater.
    for (substringLen in 3..n) {
        // Iterate through each substring of length 'substringLen'.
        for (i in 0 until n - substringLen + 1) {
            val j = i + substringLen - 1
            // If the first and last characters are the same, and the
            // inner substring is a palindrome, then the current
            // substring is a palindrome.
            if (s[i] == s[j] && dp[i + 1][j - 1]) {
                dp[i][j] = true
                maxLen = substringLen
                startIndex = i
            }
        }
    }
    return s.substring(startIndex, startIndex + maxLen)
}
