import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class KMostFrequentStringsMaxHeap {
    public class Pair implements Comparable<Pair> {
        String str;
        int freq;
        public Pair(String str, int freq) {
            this.str = str;
            this.freq = freq;
        }
        // Define a custom compareTo().
        @Override
        public int compareTo(Pair other) {
            // Prioritize lexicographical order for strings with equal
            // frequencies.
            if (this.freq == other.freq) {
                return other.str.compareTo(this.str);
            }
            // Otherwise, prioritize strings with higher frequencies.
            return Integer.compare(this.freq, other.freq);
        }
    }

    public List<String> kMostFrequentStringsMaxHeap(String[] strs, int k) {
        List<String> res = new ArrayList<>();
        // We use a hash map to count the frequency of each string.
        Map<String, Integer> freqs = new HashMap<>();
        for (String str : strs) {
            freqs.put(str, freqs.getOrDefault(str, 0) + 1);
        }
        // Create the max heap by using PriorityQueue with reverse order 
        // on all string-frequency pairs.
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (Map.Entry<String, Integer> entry : freqs.entrySet()) {
            maxHeap.add(new Pair(entry.getKey(), entry.getValue()));
        }
        // Pop the most frequent string off the heap 'k' times and return 
        // these 'k' most frequent strings.
        for (int i = 0; i < k; i++) {
            res.add(maxHeap.poll().str);
        }
        return res;
    }
}
