fun findTheMedianFromTwoSortedArrays(nums1: List<Int>, nums2: List<Int>): Double {
    val m = nums1.size
    val n = nums2.size
    // Ensure 'nums1' is the smaller array.
    if (m > n) {
        return findTheMedianFromTwoSortedArrays(nums2, nums1)
    }
    var left = 0
    var right = m - 1
    val halfTotalLen = (m + n) / 2
    // A median always exists in a non-empty array, so continue binary search until
    // it’s found.
    while (true) {
        val L1Index = (left + right) / 2
        val L2Index = halfTotalLen - (L1Index + 1) - 1
        // Set to -infinity or +infinity if out of bounds.
        val L1 = if (L1Index < 0) Double.MIN_VALUE else nums1[L1Index].toDouble()
        val R1 = if (L1Index >= m - 1) Double.MAX_VALUE else nums1[L1Index + 1].toDouble()
        val L2 = if (L2Index < 0) Double.MIN_VALUE else nums2[L2Index].toDouble()
        val R2 = if (L2Index >= n - 1) Double.MAX_VALUE else nums2[L2Index + 1].toDouble()
        // If 'L1 > R2', then 'L1' is too far to the right. Narrow the search space
        // toward the left.
        if (L1 > R2) {
            right = L1Index - 1
            // If 'L2 > R1', then 'L1' is too far to the left. Narrow the search space
            // toward the right.
        } else if (L2 > R1) {
            left = L1Index + 1
            // If both 'L1' and 'L2' are less than or equal to both 'R1' and 'R2', we
            // found the correct slice.
        } else {
            return if ((m + n) % 2 == 0) {
                (maxOf(L1, L2) + minOf(R1, R2)) / 2.0
            } else {
                minOf(R1, R2)
            }
        }
    }
}
