#include <vector>
#include <deque>

int matrixInfection(std::vector<std::vector<int>>& matrix) {
    std::vector<std::pair<int, int>> dirs = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
    std::deque<std::pair<int, int>> queue;
    int ones = 0, seconds = 0;
    // Count the total number of uninfected cells and add each infected 
    // cell to the queue to represent level 0 of the level-order traversal.
    for (int r = 0; r < matrix.size(); r++) {
        for (int c = 0; c < matrix[0].size(); c++) {
            if (matrix[r][c] == 1) {
                ones++;
            } else if (matrix[r][c] == 2) {
                queue.push_back({r, c});
            }
        }
    }
    // Use level-order traversal to determine how long it takes to 
    // infect the uninfected cells.
    while (!queue.empty() && ones > 0) {
        // 1 second passes with each level of the matrix that's explored.
        seconds++;
        int size = queue.size();
        for (int unused = 0; unused < size; unused++) {
            auto [r, c] = queue.front();
            queue.pop_front();
            // Infect any neighboring 1s and add them to the queue to be 
            // processed in the next level.
            for (auto& d : dirs) {
                int nextR = r + d.first;
                int nextC = c + d.second;
                if (isWithinBounds(nextR, nextC, matrix) && matrix[nextR][nextC] == 1) {
                    matrix[nextR][nextC] = 2;
                    ones--;
                    queue.push_back({nextR, nextC});
                }
            }
        }
    }
    // If there are still uninfected cells left, return -1. Otherwise, 
    // return the time passed.
    return ones == 0 ? seconds : -1;
}

bool isWithinBounds(int r, int c, std::vector<std::vector<int>>& matrix) {
    return r >= 0 && r < matrix.size() && c >= 0 && c < matrix[0].size();
}