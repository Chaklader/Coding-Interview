func nextLexicographicalSequence(s string) string {
	letters := []rune(s)
	// Locate the pivot, which is the first character from the right that breaks
	// non-increasing order. Start searching from the second-to-last position.
	pivot := len(letters) - 2
	for pivot >= 0 && letters[pivot] >= letters[pivot+1] {
		pivot--
	}
	// If pivot is not found, the string is already in its largest permutation. In
	// this case, reverse the string to obtain the smallest permutation.
	if pivot == -1 {
		reverse(letters, 0)
		return string(letters)
	}
	// Find the rightmost successor to the pivot.
	rightmostSuccessor := len(letters) - 1
	for letters[rightmostSuccessor] <= letters[pivot] {
		rightmostSuccessor--
	}
	// Swap the rightmost successor with the pivot to increase the lexicographical
	// order of the suffix.
	letters[pivot], letters[rightmostSuccessor] = letters[rightmostSuccessor], letters[pivot]
	// Reverse the suffix after the pivot to minimize its permutation.
	reverse(letters, pivot+1)
	return string(letters)
}

func reverse(s []rune, start int) {
	end := len(s) - 1
	for start < end {
		s[start], s[end] = s[end], s[start]
		start++
		end--
	}
}
