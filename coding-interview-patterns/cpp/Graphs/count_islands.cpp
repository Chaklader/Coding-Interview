#include <vector>

int countIslands(std::vector<std::vector<int>>& matrix) {
    if (matrix.empty()) {
        return 0;
    }
    int count = 0;
    for (int r = 0; r < matrix.size(); r++) {
        for (int c = 0; c < matrix[0].size(); c++) {
            // If a land cell is found, perform DFS to explore the full
            // island, and include this island in our count.
            if (matrix[r][c] == 1) {
                dfs(r, c, matrix);
                count += 1;
            }
        }
    }
    return count;
}

void dfs(int r, int c, std::vector<std::vector<int>>& matrix) {
    // Mark the current land cell as visited.
    matrix[r][c] = -1;
    // Define direction vectors for up, down, left, and right.
    int dirs[4][2] = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
    // Recursively call DFS on each neighboring land cell to continue
    // exploring this island.
    for (int i = 0; i < 4; i++) {
        int nextR = r + dirs[i][0];
        int nextC = c + dirs[i][1];
        if (isWithinBounds(nextR, nextC, matrix) && matrix[nextR][nextC] == 1) {
            dfs(nextR, nextC, matrix);
        }
    }
}

bool isWithinBounds(int r, int c, std::vector<std::vector<int>>& matrix) {
    return r >= 0 && r < matrix.size() && c >= 0 && c < matrix[0].size();
}