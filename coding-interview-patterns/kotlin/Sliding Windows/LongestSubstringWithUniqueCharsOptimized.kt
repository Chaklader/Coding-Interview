fun longestSubstringWithUniqueCharsOptimized(s: String): Int {
    var maxLen = 0
    val prevIndexes = mutableMapOf<Char, Int>()
    var left = 0
    var right = 0
    while (right < s.length) {
        // If a previous index of the current character is present
        // in the current window, it's a duplicate character in the
        // window.
        if (s[right] in prevIndexes && prevIndexes[s[right]]!! >= left) {
            // Shrink the window to exclude the previous occurrence
            // of this character.
            left = prevIndexes[s[right]]!! + 1
        }
        // Update 'maxLen' if the current window is larger.
        maxLen = maxOf(maxLen, right - left + 1)
        prevIndexes[s[right]] = right
        // Expand the window.
        right++
    }
    return maxLen
}