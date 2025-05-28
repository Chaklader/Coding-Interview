fun longestPalindromeInAStringExpanding(s: String): String {
    val n = s.length
    var start = 0
    var maxLen = 0
    for (center in 0 until n) {
        // Check for odd-length palindromes.
        val (oddStart, oddLength) = expandPalindrome(center, center, s)
        if (oddLength > maxLen) {
            start = oddStart
            maxLen = oddLength
        }
        // Check for even-length palindromes.
        if (center < n - 1 && s[center] == s[center + 1]) {
            val (evenStart, evenLength) = expandPalindrome(center, center + 1, s)
            if (evenLength > maxLen) {
                start = evenStart
                maxLen = evenLength
            }
        }
    }
    return s.substring(start, start + maxLen)
}

// Expands outward from the center of a base case to identify the start
// index and length of the longest palindrome that extends from this
// base case.
fun expandPalindrome(left: Int, right: Int, s: String): Pair<Int, Int> {
    var l = left
    var r = right
    while (l > 0 && r < s.length - 1 && s[l - 1] == s[r + 1]) {
        l--
        r++
    }
    return l to r - l + 1
}
