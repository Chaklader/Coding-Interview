from typing import List


def largest_square_in_a_matrix_optimized(matrix: List[List[int]]) -> int:
    if not matrix:
        return 0
    m, n = len(matrix), len(matrix[0])
    prev_row = [0] * n
    max_len = 0
    # Iterate through the matrix.
    for i in range(m):
        curr_row = [0] * n
        for j in range(n):
            # Base cases: if we’re in row 0 or column 0, the largest square ending
            # here has a length of 1. This can be set by using the value in the
            # input matrix.
            if i == 0 or j == 0:
                curr_row[j] = matrix[i][j]
            else:
                if matrix[i][j] == 1:
                      # curr_row[j] = 1 + min(left, top-left, top)
                    curr_row[j] = 1 + min(curr_row[j - 1], prev_row[j - 1], prev_row[j])
            max_len = max(max_len, curr_row[j])
        # Update 'prev_row' with 'curr_row' values for the next iteration.
        prev_row, curr_row = curr_row, [0] * n
    return max_len ** 2