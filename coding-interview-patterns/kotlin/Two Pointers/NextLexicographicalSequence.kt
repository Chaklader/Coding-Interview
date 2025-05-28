fun nextLexicographicalSequence(s: String): String {
    val letters = s.toCharArray()

    // Locate the pivot, which is the first character from the right that breaks
    // non-increasing order. Start searching from the second-to-last position,
    // since the last character is neither increasing nor decreasing.
    var pivot = letters.size - 2
    while (pivot >= 0 && letters[pivot] >= letters[pivot + 1]) {
        pivot--
    }

    // If pivot is not found, the string is already in its largest permutation. In
    // this case, reverse the string to obtain the smallest permutation.
    if (pivot == -1) {
        letters.reverse()
        return letters.joinToString("")
    }

    // Find the rightmost successor to the pivot.
    var rightmostSuccessor = letters.size - 1
    while (letters[rightmostSuccessor] <= letters[pivot]) {
        rightmostSuccessor--
    }

    // Swap the rightmost successor with the pivot to increase the lexicographical
    // order of the suffix.
    letters[pivot] =
            letters[rightmostSuccessor].also { letters[rightmostSuccessor] = letters[pivot] }

    // Reverse the suffix after the pivot to minimize its permutation.
    val suffix = letters.sliceArray(pivot + 1 until letters.size)
    suffix.reverse()

    return (letters.sliceArray(0..pivot) + suffix).joinToString("")
}
