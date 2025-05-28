#include <vector>
#include <cstdlib> 
#include <ctime>   

int kthLargestIntegerQuickselect(std::vector<int>& nums, int k) {
    srand(time(nullptr)); 
    return quickselect(nums, 0, nums.size() - 1, k);
}

int quickselect(std::vector<int>& nums, int left, int right, int k) {
    int n = nums.size();
    if (left >= right) {
        return nums[left];
    }
    int randomIndex = left + rand() % (right - left + 1);
    std::swap(nums[randomIndex], nums[right]);
    int pivotIndex = partition(nums, left, right);
    // If the pivot comes before 'n - k', the ('n - k')th smallest
    // integer is somewhere to its right. Perform quickselect on the
    // right part.
    if (pivotIndex < n - k) {
        return quickselect(nums, pivotIndex + 1, right, k);
    }
    // If the pivot comes after 'n - k', the ('n - k')th smallest integer
    // is somewhere to its left. Perform quickselect on the left part.
    else if (pivotIndex > n - k) {
        return quickselect(nums, left, pivotIndex - 1, k);
    }
    // If the pivot is at index 'n - k', it's the ('n - k')th smallest
    // integer.
    else {
        return nums[pivotIndex];
    }
}

int partition(std::vector<int>& nums, int left, int right) {
    int pivot = nums[right];
    int lo = left;
    for (int i = left; i < right; i++) {
        if (nums[i] < pivot) {
            std::swap(nums[lo], nums[i]);
            lo++;
        }
    }
    std::swap(nums[lo], nums[right]);
    return lo;
}