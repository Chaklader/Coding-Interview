#include <vector>
#include <set>

std::vector<std::vector<int>> findAllPermutations(std::vector<int>& nums) {
    std::vector<std::vector<int>> res;
    std::vector<int> candidate;
    std::set<int> used;
    backtrack(nums, candidate, used, res);
    return res;
}

void backtrack(std::vector<int>& nums, std::vector<int>& candidate, std::set<int>& used, std::vector<std::vector<int>>& res) {
    // If the current candidate is a complete permutation, add it to the 
    // result.
    if (candidate.size() == nums.size()) {
        res.push_back(candidate);
        return;
    }
    for (int num : nums) {
        if (used.find(num) == used.end()) {
            // Add 'num' to the current permutation and mark it as used.
            candidate.push_back(num);
            used.insert(num);
            // Recursively explore all branches using the updated 
            // permutation candidate.
            backtrack(nums, candidate, used, res);
            // Backtrack by reversing the changes made.
            candidate.pop_back();
            used.erase(num);
        }
    }
}