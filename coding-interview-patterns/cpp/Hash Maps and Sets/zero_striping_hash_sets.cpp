#include <vector>        
#include <unordered_set> 

void zeroStripingHashSets(std::vector<std::vector<int>>& matrix) {
    if (matrix.empty() || matrix[0].empty()) {
        return;
    }
    int m = matrix.size();        
    int n = matrix[0].size();     
    std::unordered_set<int> zeroRows; 
    std::unordered_set<int> zeroCols;
    // # Pass 1: Traverse through the matrix to identify the rows and
    // columns containing zeros and store their indexes in the 
    // appropriate hash sets.
    for (int r = 0; r < m; r++) {       
        for (int c = 0; c < n; c++) {    
            if (matrix[r][c] == 0) {
                zeroRows.insert(r);     
                zeroCols.insert(c);     
            }
        }
    }
    // Pass 2: Set any cell in the matrix to zero if its row index is 
    // in 'zero_rows' or its column index is in 'zero_cols'.
    for (int r = 0; r < m; r++) {        
        for (int c = 0; c < n; c++) {    
            if (zeroRows.find(r) != zeroRows.end() || zeroCols.find(c) != zeroCols.end()) {
                matrix[r][c] = 0;
            }
        }
    }
}