#include <vector>        
#include <set>

bool verifySudokuBoard(std::vector<std::vector<int>>& board) {
    // Create hash sets for each row, column, and subgrid to keep 
    // track of numbers previously seen on any given row, column, or
    // subgrid.
    std::vector<std::set<int>> rowSets(9);
    std::vector<std::set<int>> columnSets(9);
    std::vector<std::vector<std::set<int>>> subgridSets(3, std::vector<std::set<int>>(3));    
    for (int r = 0; r < 9; r++) {          
        for (int c = 0; c < 9; c++) {     
            int num = board[r][c];        
            if (num == 0) {
                continue;
            }
            // Check if 'num' has been seen in the current row, 
            // column, or subgrid.
            if (rowSets[r].find(num) != rowSets[r].end()) {
                return false;
            }
            if (columnSets[c].find(num) != columnSets[c].end()) {
                return false;
            }
            if (subgridSets[r / 3][c / 3].find(num) != subgridSets[r / 3][c / 3].end()) {
                return false;
            }
            // If we passed the above checks, mark this value as seen 
            // by adding it to its corresponding hash sets.            
            rowSets[r].insert(num);
            columnSets[c].insert(num);
            subgridSets[r / 3][c / 3].insert(num);
        }
    }
    return true;
}