#include <string>
#include <unordered_set>
#include <algorithm>

int longestSubstringWithUniqueChars(std::string s) {
    int maxLen = 0;
    std::unordered_set<char> hashSet;
    int left = 0;
    int right = 0;
    while (right < s.length()) {
        // If we encounter a duplicate character in the window, shrink
        // the window until it's no longer a duplicate.
        while (hashSet.find(s[right]) != hashSet.end()) {
            hashSet.erase(s[left]);
            left++;
        }
        // Once there are no more duplicates in the window, update
        // 'maxLen' if the current window is larger.
        maxLen = std::max(maxLen, right - left + 1);
        hashSet.insert(s[right]);
        // Expand the window.
        right++;
    }
    return maxLen;
}