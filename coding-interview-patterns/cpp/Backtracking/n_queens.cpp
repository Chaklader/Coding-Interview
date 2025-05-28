#include <set>

int nQueens(int n) {
    int res = 0;
    std::set<int> diagonalsSet;
    std::set<int> antiDiagonalsSet;
    std::set<int> colsSet;
    dfs(0, diagonalsSet, antiDiagonalsSet, colsSet, n, res);
    return res;
}

void dfs(int r, std::set<int>& diagonalsSet, std::set<int>& antiDiagonalsSet, std::set<int>& colsSet, int n, int& res) {
    // Termination condition: If we have reached the end of the rows,
    // we've placed all 'n' queens.
    if (r == n) {
        res += 1;
        return;
    }
    for (int c = 0; c < n; c++) {
        int currDiagonal = r - c;
        int currAntiDiagonal = r + c;
        // If there are queens on the current column, diagonal, or
        // anti-diagonal, skip this square.
        if (colsSet.count(c) || diagonalsSet.count(currDiagonal) || antiDiagonalsSet.count(currAntiDiagonal)) {
            continue;
        }
        // Place the queen by marking the current column, diagonal, and
        // anti-diagonal as occupied.
        colsSet.insert(c);
        diagonalsSet.insert(currDiagonal);
        antiDiagonalsSet.insert(currAntiDiagonal);
        // Recursively move to the next row to continue placing queens.
        dfs(r + 1, diagonalsSet, antiDiagonalsSet, colsSet, n, res);
        // Backtrack by removing the current column, diagonal, and
        // anti-diagonal from the sets.
        colsSet.erase(c);
        diagonalsSet.erase(currDiagonal);
        antiDiagonalsSet.erase(currAntiDiagonal);
    }
}