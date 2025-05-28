#include <vector>
#include <algorithm>
#include <limits>

int maximumSubarraySum(std::vector<int>& nums) {
    if (nums.empty()) {
        return 0;
    }
    // Set `maxSum` to negative infinity to ensure negative
    // sums can be considered.
    int maxSum = std::numeric_limits<int>::min();
    int currentSum = 0;
    // Iterate through the array to find the maximum subarray sum.
    for (int num : nums) {
        // Either add the current number to the existing running sum, or 
        // start a new subarray at the current number.
        currentSum = std::max(currentSum + num, num);
        maxSum = std::max(maxSum, currentSum);
    }
    return maxSum;
}