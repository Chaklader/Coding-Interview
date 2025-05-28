func isPalindromeValid(input string) bool {
	s := []rune(input)

	left, right := 0, len(s)-1

	for left < right {
		// Skip non-alphanumeric characters from the left.
		for left < right && !isAlnum(s[left]) {
			left++
		}
		// Skip non-alphanumeric characters from the right.
		for left < right && !isAlnum(s[right]) {
			right--
		}
		// If the characters at the left and right pointers don't
		// match, the string is not a palindrome.
		if s[left] != s[right] {
			return false
		}

		left++
		right--
	}

	return true
}

func isAlnum(r rune) bool {
	return unicode.IsLetter(r) || unicode.IsDigit(r)
}
