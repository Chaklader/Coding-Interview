import java.util.PriorityQueue

data class Pair(val str: String, val freq: Int)

fun kMostFrequentStringsMaxHeap(strs: List<String>, k: Int): List<String> {
    // We use 'groupingBy' to create a hash map that counts the frequency
    // of each string.
    val freqs = strs.groupingBy { it }.eachCount()
    // Create the max heap by performing heapify on all string-frequency
    val maxHeap =
            PriorityQueue<Pair> { a, b -> // Define a custom comparator.
                // Prioritize lexicographical order for strings with equal
                // frequencies.
                if (a.freq == b.freq) b.str.compareTo(a.str)
                // Otherwise, prioritize strings with higher frequencies.
                else b.freq.compareTo(a.freq)
            }
    maxHeap.addAll(freqs.map { Pair(it.key, it.value) })
    // Pop the most frequent string off the heap 'k' times and return
    // these 'k' most frequent strings.
    return List(k) { maxHeap.poll().str }
}
