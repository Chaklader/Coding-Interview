from collections import Counter
import heapq
from typing import List


class Pair:
    def __init__(self, str, freq):
        self.str = str
        self.freq = freq
    # Since this is a min-heap comparator, we can use the same 
    # comparator as the one used in the max-heap, but reversing the 
    # inequality signs to invert the priority.
    def __lt__(self, other):
        if self.freq == other.freq:
            return self.str > other.str
        return self.freq < other.freq
   
def k_most_frequent_strings_min_heap(strs: List[str], k: int) -> List[str]:
    freqs = Counter(strs)
    min_heap = []
    for str, freq in freqs.items():
        heapq.heappush(min_heap, Pair(str, freq))
        # If heap size exceeds 'k', pop the lowest frequency string to 
        # ensure the heap only contains the 'k' most frequent words so 
        # far.
        if len(min_heap) > k:
            heapq.heappop(min_heap)
    # Return the 'k' most frequent strings by popping the remaining 'k' 
    # strings from the heap. Since we're using a min-heap, we need to 
    # reverse the result after popping the elements to ensure the most 
    # frequent strings are listed first.
    res = [heapq.heappop(min_heap).str for _ in range(k)]
    res.reverse()
    return res
