import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class KMostFrequentStringsMinHeap {
    public class Pair implements Comparable<Pair> {
        String str;
        int freq;
        public Pair(String str, int freq) {
            this.str = str;
            this.freq = freq;
        }
        // Since this is a min-heap compareTo(), we can use the same 
        // compareTo() as the one used in the max-heap.
        @Override
        public int compareTo(Pair other) {
            if (this.freq == other.freq) {
                return other.str.compareTo(this.str);
            }
            return Integer.compare(this.freq, other.freq);
        }
    }

    public List<String> kMostFrequentStringsMinHeap(String[] strs, int k) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> freqs = new HashMap<>();
        for (String str : strs) {
            freqs.put(str, freqs.getOrDefault(str, 0) + 1);
        }
        PriorityQueue<Pair> minHeap = new PriorityQueue<>();
        for (Map.Entry<String, Integer> entry : freqs.entrySet()) {
            minHeap.add(new Pair(entry.getKey(), entry.getValue()));
            // If heap size exceeds 'k', pop the lowest frequency string to 
            // ensure the heap only contains the 'k' most frequent words so 
            // far.
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        // Return the 'k' most frequent strings by popping the remaining 'k' 
        // strings from the heap. Since we're using a min-heap, we need to 
        // reverse the result after popping the elements to ensure the most 
        // frequent strings are listed first.
        while (!minHeap.isEmpty()) {
            res.add(minHeap.poll().str);
        }
        Collections.reverse(res);
        return res;
    }
}
