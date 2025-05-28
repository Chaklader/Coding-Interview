#include <vector>
#include <algorithm>

int maximumSubarraySumDpOptimized(std::vector<int>& nums) {
    int n = nums.size();
    if (n == 0) {
        return 0;
    }
    int currentSum = nums[0];
    int maxSum = nums[0];
    for (int i = 1; i < n; i++) {
        currentSum = std::max(nums[i], currentSum + nums[i]);
        maxSum = std::max(maxSum, currentSum);
    }
    return maxSum;
}