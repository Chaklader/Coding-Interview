#include <vector>        
#include <unordered_set> 
#include <algorithm>    

int longestChainOfConsecutiveNumbers(std::vector<int>& nums) {
    if (nums.empty()) {
        return 0;
    }
    std::unordered_set<int> numSet(nums.begin(), nums.end());
    int longestChain = 0;
    for (int num : numSet) {
        // If the current number is the smallest number in its chain, search for
        // the length of its chain.
        if (numSet.find(num - 1) == numSet.end()) {
            int currentNum = num;    
            int currentChain = 1;    
            // Continue to find the next consecutive numbers in the chain.
            while (numSet.find(currentNum + 1) != numSet.end()) {
                currentNum += 1;    
                currentChain += 1;   
            }
            longestChain = std::max(longestChain, currentChain);
        }
    }
    return longestChain;
}