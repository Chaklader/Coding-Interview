#include <vector>

std::vector<std::vector<int>> findAllSubsets(std::vector<int>& nums) {
    std::vector<std::vector<int>> res;
    std::vector<int> currSubset;
    backtrack(0, currSubset, nums, res);
    return res;
}

void backtrack(int i, std::vector<int>& currSubset, std::vector<int>& nums, std::vector<std::vector<int>>& res) {
    // Base case: if all elements have been considered, 
    // add the current subset to the output.
    if (i == nums.size()) {
        res.push_back(currSubset);
        return;
    }
    // Include the current element and recursively explore all paths 
    // that branch from this subset.
    currSubset.push_back(nums[i]);
    backtrack(i + 1, currSubset, nums, res);
    // Exclude the current element and recursively explore all paths 
    // that branch from this subset.
    currSubset.pop_back();
    backtrack(i + 1, currSubset, nums, res);
}