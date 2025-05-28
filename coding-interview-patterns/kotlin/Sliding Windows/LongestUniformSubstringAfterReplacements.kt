fun longestUniformSubstringAfterReplacements(s: String, k: Int): Int {
    val freqs = mutableMapOf<Char, Int>()
    var highestFreq = 0
    var maxLen = 0
    var left = 0
    var right = 0
    while (right < s.length) {
        // Update the frequency of the character at the right pointer
        // and the highest frequency for the current window.
        freqs[s[right]] = freqs.getOrDefault(s[right], 0) + 1
        highestFreq = maxOf(highestFreq, freqs[s[right]]!!)
        // Calculate replacements needed for the current window.
        val numCharsToReplace = (right - left + 1) - highestFreq
        // Slide the window if the number of replacements needed exceeds
        // 'k'. The right pointer always gets advanced, so we just need
        // to advance 'left'.
        if (numCharsToReplace > k) {
            // Remove the character at the left pointer from the hash map
            // before advancing the left pointer.
            freqs[s[left]] = freqs[s[left]]!! - 1
            left++
        }
        // Since the length of the current window increases or stays the
        // same, assign  the length of the current window to 'maxLen'.
        maxLen = right - left + 1
        // Expand the window.
        right++
    }
    return maxLen
}
