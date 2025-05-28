#include <vector>
#include <algorithm>

void dutchNationalFlag(std::vector<int>& nums) {
    int i = 0, left = 0, right = nums.size() - 1;
    while (i <= right) {
        // Swap 0s with the element at the left pointer.
        if (nums[i] == 0) {
            std::swap(nums[i], nums[left]);
            left++;
            i++;
        }
        // Swap 2s with the element at the right pointer.
        else if (nums[i] == 2) {
            std::swap(nums[i], nums[right]);
            right--;
        }
        else {
            i++;
        }
    }
}