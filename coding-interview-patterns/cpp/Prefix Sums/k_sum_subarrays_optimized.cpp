#include <vector>
#include <unordered_map>

int kSumSubarraysOptimized(std::vector<int>& nums, int k) {
    int count = 0;
    // Initialize the map with 0 to handle subarrays that sum to 'k' 
    // from the start of the array.
    std::unordered_map<int, int> prefixSumMap;
    prefixSumMap[0] = 1;
    int currPrefixSum = 0;
    for (int num : nums) {
        // Update the running prefix sum by adding the current number.
        currPrefixSum += num;
        // If a subarray with sum 'k' exists, increment 'count' by the 
        // number of times it has been found.
        if (prefixSumMap.find(currPrefixSum - k) != prefixSumMap.end()) {
            count += prefixSumMap[currPrefixSum - k];
        }
        // Update the frequency of 'currPrefixSum' in the hash map.
        int freq = prefixSumMap[currPrefixSum];
        prefixSumMap[currPrefixSum] = freq + 1;
    }
    return count;
}