#include <vector>
#include <cstdlib>   
#include <ctime>     
#include <algorithm> 

std::vector<int> sortArray(std::vector<int>& nums) {
    srand(time(nullptr)); 
    quicksortOptimized(nums, 0, nums.size() - 1);
    return nums;
}

void quicksortOptimized(std::vector<int>& nums, int left, int right) {
    if (left >= right) {
        return;
    }
    // Choose a pivot at a random index.
    int randomIndex = left + rand() % (right - left + 1);
    // Swap the randomly chosen pivot with the rightmost element to
    // position the pivot at the rightmost index.
    std::swap(nums[randomIndex], nums[right]);
    int pivotIndex = partition(nums, left, right);
    quicksortOptimized(nums, left, pivotIndex - 1);
    quicksortOptimized(nums, pivotIndex + 1, right);
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