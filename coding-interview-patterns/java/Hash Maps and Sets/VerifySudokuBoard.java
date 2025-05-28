import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class VerifySudokuBoard {
    public boolean verifySudokuBoard(int[][] board) {
        // Create hash sets for each row, column, and subgrid to keep 
        // track of numbers previously seen on any given row, column, or 
        // subgrid.
        List<Set<Integer>> rowSets = new ArrayList<>(9);
        List<Set<Integer>> columnSets = new ArrayList<>(9);
        List<List<Set<Integer>>> subgridSets = new ArrayList<>(3);

        // Initialize the row and column sets.
        for (int i = 0; i < 9; i++) {
            rowSets.add(new HashSet<>());
            columnSets.add(new HashSet<>());
        }

        // Initialize the subgrid sets (3 x 3 = 9 subgrids).
        for (int i = 0; i < 3; i++) {
            List<Set<Integer>> subgridRow = new ArrayList<>(3);
            for (int j = 0; j < 3; j++) {
                subgridRow.add(new HashSet<>());
            }
            subgridSets.add(subgridRow);
        }

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                int num = board[r][c];
                if (num == 0) {
                    continue;
                }
                // Check if 'num' has been seen in the current row, 
                // column, or subgrid.
                if (rowSets.get(r).contains(num)) {
                    return false;
                }
                if (columnSets.get(c).contains(num)) {
                    return false;
                }
                if (subgridSets.get(r / 3).get(c / 3).contains(num)) {
                    return false;
                }
                // If we passed the above checks, mark this value as seen 
                // by adding it to its corresponding hash sets.
                rowSets.get(r).add(num);
                columnSets.get(c).add(num);
                subgridSets.get(r / 3).get(c / 3).add(num);
            }
        }
        return true;
    }
}
