#include <vector>        
#include <algorithm>    

int longestChainOfConsecutiveNumbersBruteForce(std::vector<int>& nums) {
    if (nums.empty()) {
        return 0;
    }
    int longestChain = 0;  
    // Look for chains of consecutive numbers that start from each number.
    for (int num : nums) {
        int currentNum = num;         
        int currentChain = 1;         
        // Continue to find the next consecutive numbers in the chain.
        while (std::find(nums.begin(), nums.end(), currentNum + 1) != nums.end()) {
            currentNum += 1;
            currentChain += 1;
        }
        longestChain = std::max(longestChain, currentChain);
    }
    return longestChain;
}