#include <vector>
#include <queue>

std::vector<int> sortAKSortedArray(std::vector<int>& nums, int k) {
    // Populate a min-heap with the first k + 1 values in 'nums'.
    std::priority_queue<int, std::vector<int>, std::greater<int>> minHeap;
    int n = nums.size();
    for (int i = 0; i <= k && i < n; i++) {
        minHeap.push(nums[i]);
    }
    // Replace elements in the array with the minimum from the heap at each 
    // iteration. 
    int insertIndex = 0;
    for (int i = k + 1; i < n; i++) {
        nums[insertIndex] = minHeap.top();
        minHeap.pop();
        insertIndex++;
        minHeap.push(nums[i]);
    }
    // Pop the remaining elements from the heap to finish sorting the array.
    while (!minHeap.empty()) {
        nums[insertIndex] = minHeap.top();
        minHeap.pop();
        insertIndex++;
    }
    return nums;
}