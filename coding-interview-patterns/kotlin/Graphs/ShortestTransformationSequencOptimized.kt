fun shortestTransformationSequenceOptimized(
        start: String,
        end: String,
        dictionary: List<String>
): Int {
    val dictionarySet = dictionary.toSet()
    if (start !in dictionarySet || end !in dictionarySet) {
        return 0
    }
    if (start == end) {
        return 1
    }
    val startQueue = ArrayDeque(listOf(start))
    val startVisited = mutableSetOf(start)
    val endQueue = ArrayDeque(listOf(end))
    val endVisited = mutableSetOf(end)
    var levelStart = 0
    var levelEnd = 0
    // Perform a level-order traversal from the start word and another
    // from the end word.
    while (startQueue.isNotEmpty() && endQueue.isNotEmpty()) {
        // Explore the next level of the traversal that starts from the
        // start word. If it meets the other traversal, the shortest
        // path between 'start' and 'end' has been found.
        levelStart++
        if (exploreLevel(startQueue, startVisited, endVisited, dictionarySet)) {
            return levelStart + levelEnd + 1
        }
        // Explore the next level of the traversal that starts from the
        // end word.
        levelEnd++
        if (exploreLevel(endQueue, endVisited, startVisited, dictionarySet)) {
            return levelStart + levelEnd + 1
        }
    }
    // If the traversals never met, then no path exists.
    return 0
}

// This function explores the next level in the level-order traversal
// and checks if two searches meet.
fun exploreLevel(
        queue: ArrayDeque<String>,
        visited: MutableSet<String>,
        otherVisited: MutableSet<String>,
        dictionarySet: Set<String>
): Boolean {
    val lowerCaseAlphabet = "abcdefghijklmnopqrstuvwxyz"
    repeat(queue.size) {
        val currentWord = queue.removeFirst()
        for (i in currentWord.indices) {
            for (c in lowerCaseAlphabet) {
                val nextWord = currentWord.replaceRange(i, i + 1, c.toString())
                // If 'nextWord' has been visited during the other
                // traversal, it means both searches have met.
                if (nextWord in otherVisited) {
                    return true
                }
                if (nextWord in dictionarySet && nextWord !in visited) {
                    visited.add(nextWord)
                    queue.addLast(nextWord)
                }
            }
        }
    }
    // If no word has been visited by the other traversal, the searches
    // have not met yet.
    return false
}
