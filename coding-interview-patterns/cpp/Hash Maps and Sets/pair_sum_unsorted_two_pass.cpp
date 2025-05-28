#include <vector>          
#include <unordered_map>   

std::vector<int> pairSumUnsortedTwoPass(std::vector<int>& nums, int target) {
    std::unordered_map<int, int> numMap;
    // First pass: Populate the hash map with each number and its index.
    for (int i = 0; i < nums.size(); i++) {
        numMap[nums[i]] = i; 
    }
    // Second pass: Check for each number's complement in the hash map. 
    for (int i = 0; i < nums.size(); i++) {
        int complement = target - nums[i]; 
        if (numMap.find(complement) != numMap.end() && numMap[complement] != i) {
            return {i, numMap[complement]};
        }
    }
    return {};
}