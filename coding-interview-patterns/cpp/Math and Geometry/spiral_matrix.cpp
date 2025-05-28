#include <vector>

std::vector<int> spiralMatrix(std::vector<std::vector<int>>& matrix) {
    if (matrix.empty()) {
        return {};
    }
    std::vector<int> result;
    // Initialize the matrix boundaries.
    int top = 0, bottom = matrix.size() - 1;
    int left = 0, right = matrix[0].size() - 1;
    // Traverse the matrix in spiral order.
    while (top <= bottom && left <= right) {
        // Move from left to right along the top boundary.
        for (int i = left; i <= right; i++) {
            result.push_back(matrix[top][i]);
        }
        top++;
        // Move from top to bottom along the right boundary.
        for (int i = top; i <= bottom; i++) {
            result.push_back(matrix[i][right]);
        }
        right--;
        // Check that the bottom boundary hasn't passed the top boundary
        // before moving from right to left along the bottom boundary.
        if (top <= bottom) {
            for (int i = right; i >= left; i--) {
                result.push_back(matrix[bottom][i]);
            }
            bottom--;
        }
        // Check that the left boundary hasn't passed the right boundary
        // before moving from bottom to top along the left boundary.
        if (left <= right) {
            for (int i = bottom; i >= top; i--) {
                result.push_back(matrix[i][left]);
            }
            left++;
        }
    }
    return result;
}