#include <vector>

std::vector<int> firstAndLastOccurrencesOfANumber(std::vector<int>& nums, int target) {
    int lowerBound = lowerBoundBinarySearch(nums, target);
    int upperBound = upperBoundBinarySearch(nums, target);
    return {lowerBound, upperBound};
}

int lowerBoundBinarySearch(std::vector<int>& nums, int target) {
    int left = 0, right = nums.size() - 1;
    while (left < right) {
        int mid = (left + right) / 2;
        if (nums[mid] > target) {
            right = mid - 1;
        } else if (nums[mid] < target) {
            left = mid + 1;
        } else {
            right = mid;
        }
    }
    return !nums.empty() && nums[left] == target ? left : -1;
}

int upperBoundBinarySearch(std::vector<int>& nums, int target) {
    int left = 0, right = nums.size() - 1;
    while (left < right) {
        // In upper-bound binary search, bias the midpoint to the right.
        int mid = (left + right) / 2 + 1;
        if (nums[mid] > target) {
            right = mid - 1;
        } else if (nums[mid] < target) {
            left = mid + 1;
        } else {
            left = mid;
        }
    }
    // If the target doesn't exist in the array, then it's possible that
    // 'left = mid + 1' places the left pointer outside the array when
    // 'mid == n - 1'. So, we use the right pointer in the return 
    // statement instead.
    return !nums.empty() && nums[right] == target ? right : -1;
}