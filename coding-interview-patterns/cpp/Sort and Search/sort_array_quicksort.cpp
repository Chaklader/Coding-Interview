#include <vector>
#include <algorithm> 

std::vector<int> sortArray(std::vector<int>& nums) {
    quicksort(nums, 0, nums.size() - 1);
    return nums;
}

void quicksort(std::vector<int>& nums, int left, int right) {
    // Base case: if the subarray has 0 or 1 element, it's already 
    // sorted.
    if (left >= right) {
        return;
    }
    // Partition the array and retrieve the pivot index.
    int pivotIndex = partition(nums, left, right);
    // Call quicksort on the left and right parts to recursively sort 
    // them.
    quicksort(nums, left, pivotIndex - 1);
    quicksort(nums, pivotIndex + 1, right);
}

int partition(std::vector<int>& nums, int left, int right) {
    int pivot = nums[right];
    int lo = left;
    // Move all numbers less than the pivot to the left, which
    // consequently positions all numbers greater than or equal to the
    // pivot to the right.
    for (int i = left; i < right; i++) {
        if (nums[i] < pivot) {
            std::swap(nums[lo], nums[i]);
            lo++;
        }
    }
    // After partitioning, 'lo' will be positioned where the pivot should
    // be. So, swap the pivot number with the number at the 'lo' pointer.
    std::swap(nums[lo], nums[right]);
    return lo;
}