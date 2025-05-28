#include <string>
#include <vector>

std::string longestPalindromeInAString(std::string& s) {
    int n = s.length();
    if (n == 0) {
        return "";
    }
    std::vector<std::vector<bool>> dp(n, std::vector<bool>(n, false));
    int maxLen = 1;
    int startIndex = 0;
    // Base case: a single character is always a palindrome.
    for (int i = 0; i < n; i++) {
        dp[i][i] = true;
    }
    // Base case: a substring of length two is a palindrome if both 
    // characters are the same.
    for (int i = 0; i < n - 1; i++) {
        if (s[i] == s[i + 1]) {
            dp[i][i + 1] = true;
            maxLen = 2;
            startIndex = i;
        }
    }
    // Find palindromic substrings of length 3 or greater.
    for (int substringLen = 3; substringLen <= n; substringLen++) {
        // Iterate through each substring of length 'substringLen'.
        for (int i = 0; i <= n - substringLen; i++) {
            int j = i + substringLen - 1;
            // If the first and last characters are the same, and the 
            // inner substring is a palindrome, then the current 
            // substring is a palindrome.
            if (s[i] == s[j] && dp[i + 1][j - 1]) {
                dp[i][j] = true;
                maxLen = substringLen;
                startIndex = i;
            }
        }
    }
    return s.substr(startIndex, maxLen);
}