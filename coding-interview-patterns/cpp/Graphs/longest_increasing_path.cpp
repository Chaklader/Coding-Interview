#include <vector>
#include <algorithm>

int longestIncreasingPath(std::vector<std::vector<int>>& matrix) {
    if (matrix.empty()) {
        return 0;
    }
    int res = 0;
    int m = matrix.size();
    int n = matrix[0].size();
    std::vector<std::vector<int>> memo(m, std::vector<int>(n, 0));
    // Find the longest increasing path starting at each cell. The
    // maximum of these is equal to the overall longest increasing
    // path.
    for (int r = 0; r < m; r++) {
        for (int c = 0; c < n; c++) {
            res = std::max(res, dfs(r, c, matrix, memo));
        }
    }
    return res;
}

int dfs(int r, int c, std::vector<std::vector<int>>& matrix, std::vector<std::vector<int>>& memo) {
    if (memo[r][c] != 0) {
        return memo[r][c];
    }
    int maxPath = 1;
    std::vector<std::pair<int, int>> dirs = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
    // The longest path starting at the current cell is equal to the
    // longest path of its larger neighboring cells, plus 1.
    for (auto& d : dirs) {
        int nextR = r + d.first;
        int nextC = c + d.second;
        if (isWithinBounds(nextR, nextC, matrix) && matrix[nextR][nextC] > matrix[r][c]) {
            maxPath = std::max(maxPath, 1 + dfs(nextR, nextC, matrix, memo));
        }
    }
    memo[r][c] = maxPath;
    return maxPath;
}

bool isWithinBounds(int r, int c, std::vector<std::vector<int>>& matrix) {
    return r >= 0 && r < matrix.size() && c >= 0 && c < matrix[0].size();
}