fun substringAnagrams(s: String, t: String): Int {
    val lenS = s.length
    val lenT = t.length
    if (lenT > lenS) {
        return 0
    }
    var count = 0
    val expectedFreqs = IntArray(26)
    val windowFreqs = IntArray(26)
    // Populate 'expected_freqs' with the characters in string 't'.
    for (c in t) {
        expectedFreqs[c - 'a']++
    }
    var left = 0
    var right = 0
    while (right < lenS) {
        // Add the character at the right pointer to 'window_freqs'
        // before sliding the window.
        windowFreqs[s[right] - 'a']++
        // If the window has reached the expected fixed length, we
        // advance the left pointer as well as the right pointer to
        // slide the window.
        if (right - left + 1 == lenT) {
            if (windowFreqs.contentEquals(expectedFreqs)) {
                count++
            }
            // Remove the character at the left pointer from
            // 'window_freqs' before advancing the left pointer.
            windowFreqs[s[left] - 'a']--
            left++
        }
        right++
    }
    return count
}
