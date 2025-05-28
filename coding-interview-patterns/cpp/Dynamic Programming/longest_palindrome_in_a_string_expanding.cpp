#include <string>
#include <utility>

std::string longestPalindromeInAStringExpanding(std::string& s) {
    int n = s.length();
    int start = 0;
    int maxLen = 0;
    for (int center = 0; center < n; center++) {
        // Check for odd-length palindromes.
        std::pair<int, int> oddResult = expandPalindrome(center, center, s);
        int oddStart = oddResult.first;
        int oddLength = oddResult.second;
        if (oddLength > maxLen) {
            start = oddStart;
            maxLen = oddLength;
        }
        // Check for even-length palindromes.
        if (center < n - 1 && s[center] == s[center + 1]) {
            std::pair<int, int> evenResult = expandPalindrome(center, center + 1, s);
            int evenStart = evenResult.first;
            int evenLength = evenResult.second;
            if (evenLength > maxLen) {
                start = evenStart;
                maxLen = evenLength;
            }
        }
    }
    return s.substr(start, maxLen);
}

// Expands outward from the center of a base case to identify the start 
// index and length of the longest palindrome that extends from this 
// base case.
std::pair<int, int> expandPalindrome(int left, int right, std::string& s) {
    while (left > 0 && right < s.length() - 1 && s[left - 1] == s[right + 1]) {
        left--;
        right++;
    }
    return {left, right - left + 1};
}