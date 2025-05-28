#include <vector>

bool matrixSearch(std::vector<std::vector<int>>& matrix, int target) {
    int m = matrix.size(), n = matrix[0].size();
    int left = 0, right = m * n - 1;
    // Perform binary search to find the target.
    while (left <= right) {
        int mid = (left + right) / 2;
        int r = mid / n;
        int c = mid % n;
        if (matrix[r][c] == target) {
            return true;
        } else if (matrix[r][c] > target) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }
    return false;
}