public class Solution
{
    public bool VerifySudokuBoard(int[][] board)
    {
        // Create hash sets for each row, column, and subgrid to keep 
        // track of numbers previously seen on any given row, column, or 
        // subgrid.
        HashSet<int>[] rowSets = new HashSet<int>[9];
        HashSet<int>[] columnSets = new HashSet<int>[9];
        HashSet<int>[,] subgridSets = new HashSet<int>[3, 3];

        // Initializing row and column sets.
        for (int i = 0; i < 9; i++) 
        {
            rowSets[i] = new HashSet<int>();
            columnSets[i] = new HashSet<int>();
        }

        // Initializing the subgrid sets.
        for (int i = 0; i < 3; i++) 
        {
            for (int j = 0; j < 3; j++)
            {
                subgridSets[i, j] = new HashSet<int>();
            }
        }
        
        for (int r = 0; r < 9; r++) 
        {
            for (int c = 0; c < 9; c++)
            {
                int num = board[r][c];
                if (num == 0)
                {
                    continue;
                }
                // Check if 'num' has been seen in the current row, 
                // column, or subgrid.
                if (rowSets[r].Contains(num))
                {
                    return false;
                }
                if (columnSets[c].Contains(num))
                {
                    return false;
                }
                if (subgridSets[r / 3, c / 3].Contains(num))
                {
                    return false;
                }
                // If we passed the above checks, mark this value as seen 
                // by adding it to its corresponding hash sets.
                rowSets[r].Add(num);
                columnSets[c].Add(num);
                subgridSets[r / 3, c / 3].Add(num);
            }
        }

        return true;
    }
}