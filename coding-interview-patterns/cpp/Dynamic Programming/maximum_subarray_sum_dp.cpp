#include <vector>
#include <algorithm>

int maximumSubarraySumDp(const std::vector<int>& nums) {
    int n = nums.size();
    if (n == 0) {
        return 0;
    }
    std::vector<int> dp(n, 0);
    // Base case: the maximum subarray sum of an array with just one 
    // element is that element.
    dp[0] = nums[0];
    int maxSum = dp[0];
    // Populate the rest of the DP array.
    for (int i = 1; i < n; i++) {
        // Determine the maximum subarray sum ending at the current 
        // index.
        dp[i] = std::max(dp[i - 1] + nums[i], nums[i]);
        maxSum = std::max(maxSum, dp[i]);
    }
    return maxSum;
}