#include <string>
#include <unordered_map>
#include <algorithm>

int longestSubstringWithUniqueCharsOptimized(std::string s) {
    int maxLen = 0;
    std::unordered_map<char, int> prevIndexes;
    int left = 0;
    int right = 0;
    while (right < s.length()) {
        // If a previous index of the current character is present
        // in the current window, it's a duplicate character in the 
        // window.
        if (prevIndexes.find(s[right]) != prevIndexes.end() && prevIndexes[s[right]] >= left) {
            // Shrink the window to exclude the previous occurrence 
            // of this character.
            left = prevIndexes[s[right]] + 1;
        }
        // Update 'maxLen' if the current window is larger.
        maxLen = std::max(maxLen, right - left + 1);
        prevIndexes[s[right]] = right;
        // Expand the window.
        right++;
    }
    return maxLen;
}