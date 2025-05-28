from collections import Counter
import heapq
from typing import List


class Pair:
    def __init__(self, str, freq):
        self.str = str
        self.freq = freq

    # Define a custom comparator.
    def __lt__(self, other):
        # Prioritize lexicographical order for strings with equal
        # frequencies.
        if self.freq == other.freq:
            return self.str < other.str
        # Otherwise, prioritize strings with higher frequencies.
        return self.freq > other.freq
   
def k_most_frequent_strings_max_heap(strs: List[str], k: int) -> List[str]:
    # We use 'Counter' to create a hash map that counts the frequency 
    # of each string.
    freqs = Counter(strs)
    # Create the max heap by performing heapify on all string-frequency 
    # pairs.
    max_heap = [Pair(str, freq) for str, freq in freqs.items()]
    heapq.heapify(max_heap)
    # Pop the most frequent string off the heap 'k' times and return 
    # these 'k' most frequent strings.
    return [heapq.heappop(max_heap).str for _ in range(k)]
