#include <string>
#include <vector>

int substringAnagrams(std::string s, std::string t) {
    int lenS = s.length();
    int lenT = t.length();
    if (lenT > lenS) {
        return 0;
    }
    int count = 0;
    std::vector<int> expectedFreqs(26, 0);
    std::vector<int> windowFreqs(26, 0);
    // Populate 'expectedFreqs' with the characters in string 't'.
    for (char c : t) {
        expectedFreqs[c - 'a'] += 1;
    }
    int left = 0;
    int right = 0;
    while (right < lenS) {
        // Add the character at the right pointer to 'windowFreqs'
        // before sliding the window.
        windowFreqs[s[right] - 'a'] += 1;
        // If the window has reached the expected fixed length, we
        // advance the left pointer as well as the right pointer to
        // slide the window.
        if (right - left + 1 == lenT) {
            if (windowFreqs == expectedFreqs) {
                count += 1;
            }
            // Remove the character at the left pointer from
            // 'windowFreqs' before advancing the left pointer.
            windowFreqs[s[left] - 'a'] -= 1;
            left += 1;
        }
        right += 1;
    }
    return count;
}