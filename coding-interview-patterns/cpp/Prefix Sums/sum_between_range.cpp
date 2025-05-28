#include <vector>

class SumBetweenRange {
public:
    SumBetweenRange(std::vector<int>& nums) {
        if (!nums.empty()) {
            prefixSum.push_back(nums[0]);
            for (int i = 1; i < nums.size(); i++) {
                prefixSum.push_back(prefixSum.back() + nums[i]);
            }
        }
    }

    int sumRange(int i, int j) {
        if (i == 0) {
            return prefixSum[j];
        }
        return prefixSum[j] - prefixSum[i - 1];
    }

private:
    std::vector<int> prefixSum;
};