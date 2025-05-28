#include <vector>
#include <algorithm>
#include <limits>
#include <cmath>

double findTheMedianFromTwoSortedArrays(std::vector<int>& nums1, std::vector<int>& nums2) {
    // Optimization: ensure 'nums1' is the smaller array.
    if (nums2.size() < nums1.size()) {
        std::swap(nums1, nums2);
    }
    int m = nums1.size();
    int n = nums2.size();
    int halfTotalLen = (m + n) / 2;
    int left = 0;
    int right = m - 1;
    // A median always exists in a non-empty array, so continue binary search until
    // it’s found. 
    while (true) {
        // Use std::floor with floating-point division to ensure correct rounding down
        // when left + right is negative, avoiding issues with integer division.
        int L1Index = std::floor((left + right) / 2.0);
        int L2Index = halfTotalLen - (L1Index + 1) - 1;
        // Set to -infinity or +infinity if out of bounds.
        double L1 = (L1Index < 0) ? -std::numeric_limits<double>::infinity() : nums1[L1Index];
        double R1 = (L1Index >= m - 1) ? std::numeric_limits<double>::infinity() : nums1[L1Index + 1];
        double L2 = (L2Index < 0) ? -std::numeric_limits<double>::infinity() : nums2[L2Index];
        double R2 = (L2Index >= n - 1) ? std::numeric_limits<double>::infinity() : nums2[L2Index + 1];
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
                return (std::max(L1, L2) + std::min(R1, R2)) / 2.0;
            } else {
                return std::min(R1, R2);
            }
        }
    }
}