import java.util.Set;

public class FindTheMedianFromTwoSortedArrays {
    public float findTheMedianFromTwoSortedArrays(int[] nums1, int[] nums2) {
        // Optimization: ensure 'nums1' is the smaller array.
        if (nums2.length < nums1.length) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
        int m = nums1.length;
        int n = nums2.length;
        int halfTotalLen = (m + n) / 2;
        int left = 0;
        int right = m - 1;
        // A median always exists in a non-empty array, so continue binary search until
        // it’s found.
        while (true) {
            // Reminder: integer division rounds toward 0 in Java
            // ex: -1 / 2 = 0
            int L1Index = Math.floorDiv(left + right, 2);
            int L2Index = halfTotalLen - (L1Index + 1) - 1;
            // Set to -infinity or +infinity if out of bounds.
            float L1 = L1Index < 0 ? Float.NEGATIVE_INFINITY : nums1[L1Index];
            float R1 = L1Index >= m - 1 ? Float.POSITIVE_INFINITY : nums1[L1Index + 1];
            float L2 = L2Index < 0 ? Float.NEGATIVE_INFINITY : nums2[L2Index];
            float R2 = L2Index >= n - 1 ? Float.POSITIVE_INFINITY : nums2[L2Index + 1];
            // If 'L1 > R2', then 'L1' is too far to the right. Narrow the search space
            // toward the left.
            if (L1 > R2) {
                right = L1Index - 1;
            }
            // If 'L2 > R1', then 'L1' is too far to the left. Narrow the search space
            // toward the right.
            else if (L2 > R1) {
                left = L1Index + 1;
            }
            // If both 'L1' and 'L2' are less than or equal to both 'R1' and 'R2', we 
            // found the correct slice.
            else {
                if ((m + n) % 2 == 0) {
                    return (Math.max(L1, L2) + Math.min(R1, R2)) / 2.0;
                } else {
                    return Math.min(R1, R2);
                }
            }
        }
    }
}
