from collections import deque
from typing import List


def matrix_infection(matrix: List[List[int]]) -> int:
    dirs = [(-1, 0), (1, 0), (0, -1), (0, 1)]
    queue = deque()
    ones = seconds = 0
    # Count the total number of uninfected cells and add each infected 
    # cell to the queue to represent level 0 of the level-order  
    # traversal.
    for r in range(len(matrix)):
        for c in range(len(matrix[0])):
            if matrix[r][c] == 1:
                ones += 1
            elif matrix[r][c] == 2:
                queue.append((r, c))
    # Use level-order traversal to determine how long it takes to 
    # infect the uninfected cells.
    while queue and ones > 0:
        # 1 second passes with each level of the matrix that's explored.
        seconds += 1
        for _ in range(len(queue)):
            r, c = queue.popleft()
            # Infect any neighboring 1s and add them to the queue to be 
            # processed in the next level.
            for d in dirs:
                next_r, next_c = r + d[0], c + d[1]
                if is_within_bounds(next_r, next_c, matrix) and matrix[next_r][next_c] == 1:
                    matrix[next_r][next_c] = 2
                    ones -= 1
                    queue.append((next_r, next_c))
    # If there are still uninfected cells left, return -1. Otherwise, 
    # return the time passed.
    return seconds if ones == 0 else -1

def is_within_bounds(r: int, c: int, matrix: List[List[int]]) -> bool:
    return 0 <= r < len(matrix) and 0 <= c < len(matrix[0])
