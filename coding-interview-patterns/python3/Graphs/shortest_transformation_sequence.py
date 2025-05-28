from collections import deque
from typing import List


def shortest_transformation_sequence(start: str, end: str, dictionary: List[str]) -> int:
    dictionary_set = set(dictionary)
    if start not in dictionary_set or end not in dictionary_set:
        return 0
    if start == end:
        return 1
    lower_case_alphabet = 'abcdefghijklmnopqrstuvwxyz'
    queue = deque([start])
    visited = set([start])
    dist = 0
    # Use level-order traversal to find the shortest path from the 
    # start word to the end word.
    while queue:
        for _ in range(len(queue)):
            curr_word = queue.popleft()
            # If we found the end word, we've reached it via the 
            # shortest path.
            if curr_word == end:
                return dist + 1
            # Generate all possible words that have a one-letter 
            # difference to the current word.
            for i in range(len(curr_word)):
                for c in lower_case_alphabet:
                    next_word = curr_word[:i] + c + curr_word[i+1:]
                    # If 'next_word' exists in the dictionary, it's a 
                    # neighbor of the current word. If unvisited, add it
                    # to the queue to be processed in the next level.
                    if next_word in dictionary_set and next_word not in visited:
                        visited.add(next_word)
                        queue.append(next_word)
        dist += 1
    # If there is no way to reach the end node, then no path exists.
    return 0
