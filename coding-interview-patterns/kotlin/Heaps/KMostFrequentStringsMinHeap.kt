import java.util.PriorityQueue

data class Pair(val str: String, val freq: Int)

fun kMostFrequentStringsMinHeap(strs: List<String>, k: Int): List<String> {
    val freqs = strs.groupingBy { it }.eachCount()
    val minHeap =
            PriorityQueue<Pair> { a, b ->
                // Since this is a min-heap comparator, we can use the same
                // comparator as the one used in the max-heap, but reversing the
                // inequality signs to invert the priority.
                if (a.freq == b.freq) a.str.compareTo(b.str) else a.freq.compareTo(b.freq)
            }
    for ((str, freq) in freqs) {
        minHeap.add(Pair(str, freq))
        // If heap size exceeds 'k', pop the lowest frequency string to
        // ensure the heap only contains the 'k' most frequent words so
        // far.
        if (minHeap.size > k) {
            minHeap.poll()
        }
    }
    // Return the 'k' most frequent strings by popping the remaining 'k'
    // strings from the heap. Since we're using a min-heap, we need to
    // reverse the result after popping the elements to ensure the most
    // frequent strings are listed first.
    return List(k) { minHeap.poll().str }.reversed()
}
