#include <vector>

int lonelyInteger(std::vector<int>& nums) {
    int res = 0;
    // XOR each element of the array so that duplicate values will
    // cancel each other out (x ^ x == 0).
    for (int i = 0; i < nums.size(); i++) {
        res ^= nums[i];
    }
    // 'res' will store the lonely integer because it would not have
    // been canceled out by any duplicate.
    return res;
}