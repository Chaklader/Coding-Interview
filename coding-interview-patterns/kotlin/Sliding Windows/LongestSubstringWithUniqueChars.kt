fun longestSubstringWithUniqueChars(s: String): Int {
    var maxLen = 0
    val hashSet = mutableSetOf<Char>()
    var left = 0
    var right = 0
    while (right < s.length) {
        // If we encounter a duplicate character in the window, shrink
        // the window until it's no longer a duplicate.
        while (s[right] in hashSet) {
            hashSet.remove(s[left])
            left++
        }
        // Once there are no more duplicates in the window, update
        // 'maxLen' if the current window is larger.
        maxLen = maxOf(maxLen, right - left + 1)
        hashSet.add(s[right])
        // Expand the window.
        right++
    }
    return maxLen
}