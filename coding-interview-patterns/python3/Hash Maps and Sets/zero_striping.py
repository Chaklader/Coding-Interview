from typing import List


def zero_striping(matrix: List[List[int]]) -> None:
    if not matrix or not matrix[0]:
        return
    m, n = len(matrix), len(matrix[0])
    # Check if the first row initially contains a zero.
    first_row_has_zero = False
    for c in range(n):
        if matrix[0][c] == 0:
            first_row_has_zero = True
            break
    # Check if the first column initially contains a zero.
    first_col_has_zero = False
    for r in range(m):
        if matrix[r][0] == 0:
            first_col_has_zero = True
            break
    # Use the first row and column as markers. If an element in the 
    # submatrix is zero, mark its corresponding row and column in the 
    # first row and column as 0.
    for r in range(1, m):
        for c in range(1, n):
            if matrix[r][c] == 0:
                matrix[0][c] = 0
                matrix[r][0] = 0
    # Update the submatrix using the markers in the first row and 
    # column.
    for r in range(1, m):
        for c in range(1, n):
            if matrix[0][c] == 0 or matrix[r][0] == 0:
                matrix[r][c] = 0
    # If the first row had a zero initially, set all elements in the 
    # first row to zero.
    if first_row_has_zero:
        for c in range(n):
            matrix[0][c] = 0
    # If the first column had a zero initially, set all elements in 
    # the first column to zero.
    if first_col_has_zero:
        for r in range(m):
            matrix[r][0] = 0
