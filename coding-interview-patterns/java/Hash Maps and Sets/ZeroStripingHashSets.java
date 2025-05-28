import java.util.HashSet;
import java.util.Set;

public class ZeroStripingHashSets {
    public void zeroStripingHashSets(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        Set<Integer> zeroRows = new HashSet<>();
        Set<Integer> zeroCols = new HashSet<>();
        // Pass 1: Traverse through the matrix to identify the rows and
        // columns containing zeros and store their indexes in the 
        // appropriate hash sets.
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (matrix[r][c] == 0) {
                    zeroRows.add(r);
                    zeroCols.add(c);
                }
            }
        }
        // Pass 2: Set any cell in the matrix to zero if its row index is 
        // in 'zeroRows' or its column index is in 'zeroCols'.
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (zeroRows.contains(r) || zeroCols.contains(c)) {
                    matrix[r][c] = 0;
                }
            }
        }
    }
}
