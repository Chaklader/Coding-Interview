#include <vector>

int findTheTargetInARotatedSortedArray(std::vector<int>& nums, int target) {
    int left = 0, right = nums.size() - 1;
    while (left < right) {
        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        // If the left subarray [left : mid] is sorted, check if the
        // target falls in this range. If it does, search the left
        // subarray. Otherwise, search the right.
        else if (nums[left] <= nums[mid]) {
            if (nums[left] <= target && target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        // If the right subarray [mid : right] is sorted, check if the
        // target falls in this range. If it does, search the right
        // subarray. Otherwise, search the left.
        else {
            if (nums[mid] < target && target <= nums[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    }
    // If the target is found in the array, return its index. Otherwise,
    // return -1.
    return nums[left] == target ? left : -1;
}