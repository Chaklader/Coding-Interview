public class Solution
{
    public void ZeroStripingHashSets(int[][] matrix)
    {
        if (matrix == null || matrix.Length == 0 || matrix[0] == null || matrix[0].Length == 0) 
        {
            return;
        }
        int m = matrix.Length, n = matrix[0].Length;
        HashSet<int> zeroRows = new HashSet<int>();
        HashSet<int> zeroCols = new HashSet<int>();
        // Pass 1: Traverse through the matrix to identify the rows and
        // columns containing zeros and store their indexes in the 
        // appropriate hash sets.
        for (int r = 0; r < m; r++) 
        {
            for (int c = 0; c < n; c++)
            {
                if (matrix[r][c] == 0)
                {
                    zeroRows.Add(r);
                    zeroCols.Add(c);
                }
            }
        }
        // Pass 2: Set any cell in the matrix to zero if its row index is 
        // in 'zero_rows' or its column index is in 'zero_cols'.
        for (int r = 0; r < m; r++)
        {
            for (int c = 0; c < n; c++)
            {
                if (zeroRows.Contains(r) || zeroCols.Contains(c))
                {
                    matrix[r][c] = 0;
                }
            }
        }
    }
}