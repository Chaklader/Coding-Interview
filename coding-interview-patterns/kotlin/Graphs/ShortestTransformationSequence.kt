fun shortestTransformationSequence(start: String, end: String, dictionary: List<String>): Int {
    val dictionarySet = dictionary.toSet()
    if (start !in dictionarySet || end !in dictionarySet) {
        return 0
    }
    if (start == end) {
        return 1
    }
    val lowerCaseAlphabet = "abcdefghijklmnopqrstuvwxyz"
    val queue = ArrayDeque(listOf(start))
    val visited = mutableSetOf(start)
    var dist = 0
    // Use level-order traversal to find the shortest path from the
    // start word to the end word.
    while (queue.isNotEmpty()) {
        for (i in 0 until queue.size) {
            val currWord = queue.removeFirst()
            // If we found the end word, we've reached it via the
            // shortest path.
            if (currWord == end) {
                return dist + 1
            }
            // Generate all possible words that have a one-letter
            // difference to the current word.
            for (j in currWord.indices) {
                for (c in lowerCaseAlphabet) {
                    val nextWord = currWord.substring(0, j) + c + currWord.substring(j + 1)
                    // If 'nextWord' exists in the dictionary, it's a
                    // neighbor of the current word. If unvisited, add it
                    // to the queue to be processed in the next level.
                    if (nextWord in dictionarySet && nextWord !in visited) {
                        visited.add(nextWord)
                        queue.addLast(nextWord)
                    }
                }
            }
        }
        dist++
    }
    // If there is no way to reach the end node, then no path exists.
    return 0
}
