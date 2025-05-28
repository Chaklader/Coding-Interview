#include <vector>
#include <algorithm>

std::vector<int> sortArrayCountingSort(std::vector<int>& nums) {
    if (nums.empty()) {
        return {};
    }
    std::vector<int> res;
    // Count occurrences of each element in 'nums'.
    int maxNum = *std::max_element(nums.begin(), nums.end());
    std::vector<int> counts(maxNum + 1, 0);
    for (int num : nums) {
        counts[num]++;
    }
    // Build the sorted array by appending each index 'i' to it a total
    // of 'counts[i]' times.
    for (int i = 0; i <= maxNum; i++) {
        for (int j = 0; j < counts[i]; j++) {
            res.push_back(i);
        }
    }
    return res;
}