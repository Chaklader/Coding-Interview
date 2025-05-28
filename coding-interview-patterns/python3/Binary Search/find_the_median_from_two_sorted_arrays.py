from typing import List


def find_the_median_from_two_sorted_arrays(nums1: List[int], nums2: List[int]) -> float:
    # Optimization: ensure 'nums1' is the smaller array.
    if len(nums2) < len(nums1):
        nums1, nums2 = nums2, nums1
    m, n = len(nums1), len(nums2)
    half_total_len = (m + n) // 2
    left, right = 0, m - 1
    # A median always exists in a non-empty array, so continue binary search until
    # it’s found.
    while True:
        L1_index = (left + right) // 2
        L2_index = half_total_len - (L1_index + 1) - 1
        # Set to -infinity or +infinity if out of bounds.
        L1 = float('-inf') if L1_index < 0 else nums1[L1_index]
        R1 = float('inf') if L1_index >= m - 1 else nums1[L1_index + 1]
        L2 = float('-inf') if L2_index < 0 else nums2[L2_index]
        R2 = float('inf') if L2_index >= n - 1 else nums2[L2_index + 1]
        # If 'L1 > R2', then 'L1' is too far to the right. Narrow the search space
        # toward the left.
        if L1 > R2:
            right = L1_index - 1
        # If 'L2 > R1', then 'L1' is too far to the left. Narrow the search space
        # toward the right.
        elif L2 > R1:
            left = L1_index + 1
        # If both 'L1' and 'L2' are less than or equal to both 'R1' and 'R2', we 
        # found the correct slice.
        else:
            if (m + n) % 2 == 0:
                return (max(L1, L2) + min(R1, R2)) / 2.0
            else:
                return min(R1, R2)