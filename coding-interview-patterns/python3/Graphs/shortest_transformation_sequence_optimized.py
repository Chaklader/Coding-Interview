from collections import deque
from typing import List


def shortest_transformation_sequence_optimized(start: str, end: str, dictionary: List[str]) -> int:
    dictionary_set = set(dictionary)
    if start not in dictionary_set or end not in dictionary_set:
        return 0
    if start == end:
        return 1
    start_queue = deque([start])
    start_visited = {start}
    end_queue = deque([end])
    end_visited = {end}
    level_start = level_end = 0
    # Perform a level-order traversal from the start word and another 
    # from the end word.
    while start_queue and end_queue:
        # Explore the next level of the traversal that starts from the 
        # start word. If it meets the other traversal, the shortest 
        # path between 'start' and 'end' has been found.
        level_start += 1
        if explore_level(start_queue, start_visited, end_visited, dictionary_set):
            return level_start + level_end + 1
        # Explore the next level of the traversal that starts from the  
        # end word.
        level_end += 1
        if explore_level(end_queue, end_visited, start_visited, dictionary_set):
            return level_start + level_end + 1
    # If the traversals never met, then no path exists.
    return 0

# This function explores the next level in the level-order traversal 
# and checks if two searches meet.
def explore_level(queue, visited, other_visited, dictionary_set) -> bool:
    lower_case_alphabet = 'abcdefghijklmnopqrstuvwxyz'
    for _ in range(len(queue)):
        current_word = queue.popleft()
        for i in range(len(current_word)):
            for c in lower_case_alphabet:
                next_word = current_word[:i] + c + current_word[i + 1:]
                # If 'next_word' has been visited during the other
                # traversal, it means both searches have met.
                if next_word in other_visited:
                    return True
                if next_word in dictionary_set and next_word not in visited:
                    visited.add(next_word)
                    queue.append(next_word)
    # If no word has been visited by the other traversal, the searches 
    # have not met yet.
    return False
