#include <vector>

std::vector<std::vector<int>> combinationsOfSumK(std::vector<int>& nums, int target) {
    std::vector<std::vector<int>> res;
    std::vector<int> combination;
    dfs(combination, 0, nums, target, res);
    return res;
}

void dfs(std::vector<int>& combination, int startIndex, std::vector<int>& nums, int target, std::vector<std::vector<int>>& res) {
    // Termination condition: If the target is equal to 0, we found a combination 
    // that sums to 'k'.
    if (target == 0) {
        res.push_back(combination);
        return;
    }
    // Termination condition: If the target is less than 0, no more valid 
    // combinations can be created by adding it to the current combination.
    if (target < 0) {
        return;
    }
    // Starting from startIndex, explore all combinations after adding nums[i].
    for (int i = startIndex; i < nums.size(); i++) {
        // Add the current number to create a new combination.
        combination.push_back(nums[i]);
        // Recursively explore all paths that branch from this new combination.
        dfs(combination, i, nums, target - nums[i], res);
        // Backtrack by removing the number we just added.
        combination.pop_back();
    }
}