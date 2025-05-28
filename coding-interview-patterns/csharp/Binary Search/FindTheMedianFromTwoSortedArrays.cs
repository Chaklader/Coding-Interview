public class Solution
{
    public double FindTheMedianFromTwoSortedArrays(int[] nums1, int[] nums2)
    {
        // Optimization: ensure 'nums1' is the smaller array.
        if (nums2.Length < nums1.Length)
            (nums1, nums2) = (nums2, nums1);

        int m = nums1.Length, n = nums2.Length;
        int halfTotalLen = (m + n) / 2;
        int left = 0, right = m - 1;

        // A median always exists in a non-empty array, so continue binary search until
        // it’s found.
        while (true)
        {
            int L1Index = (left + right) / 2;
            int L2Index = halfTotalLen - (L1Index + 1) - 1;

            // Set to -infinity or +infinity if out of bounds.
            int L1 = L1Index < 0 ? int.MinValue : nums1[L1Index];
            int R1 = L1Index >= m - 1 ? int.MaxValue : nums1[L1Index + 1];

            int L2 = L2Index < 0 ? int.MinValue : nums2[L2Index];
            int R2 = L2Index >= n - 1 ? int.MaxValue : nums2[L2Index + 1];

            // If 'L1 > R2', then 'L1' is too far to the right. Narrow the search space
            // toward the left.
            if (L1 > R2)
                right = L1Index - 1;

            // If 'L2 > R1', then 'L1' is too far to the left. Narrow the search space
            // toward the right.
            else if (L2 > R1)
                left = L1Index + 1;

            // If both 'L1' and 'L2' are less than or equal to both 'R1' and 'R2', we 
            // found the correct slice.
            else
            {
                if ((m + n) % 2 == 0)
                    return Math.Max(L1, L2) * 0.5 + Math.Min(R1, R2) * 0.5;
                else
                    return Math.Min(R1, R2);
            }
        }
    }
}
