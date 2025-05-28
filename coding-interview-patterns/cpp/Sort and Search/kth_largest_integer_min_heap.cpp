#include <vector>
#include <queue>

int kthLargestIntegerMinHeap(std::vector<int>& nums, int k) {
    std::priority_queue<int, std::vector<int>, std::greater<int>> minHeap;
    for (int num : nums) {
        // Ensure the heap has at least 'k' integers.
        if (minHeap.size() < k) {
            minHeap.push(num);
        }
        // If 'num' is greater than the smallest integer in the heap, pop
        // off this smallest integer from the heap and push in 'num'.
        else if (num > minHeap.top()) {
            minHeap.pop();
            minHeap.push(num);
        }
    }
    return minHeap.top();
}