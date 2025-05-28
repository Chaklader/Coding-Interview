#include <vector>

int kSumSubarrays(std::vector<int>& nums, int k) {
    int n = nums.size();
    int count = 0;
    // Populate the prefix sum array, setting its first element to 0.
    std::vector<int> prefixSum;
    prefixSum.push_back(0);
    for (int i = 0; i < n; i++) {
        prefixSum.push_back(prefixSum.back() + nums[i]);
    }
    // Loop through all valid pairs of prefix sum values to find all 
    // subarrays that sum to 'k'.
    for (int j = 1; j <= n; j++) {
        for (int i = 1; i <= j; i++) {
            if (prefixSum[j] - prefixSum[i - 1] == k) {
                count += 1;
            }
        }
    }
    return count;
}