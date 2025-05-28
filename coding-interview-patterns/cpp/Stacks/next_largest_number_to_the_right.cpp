#include <vector>

std::vector<int> nextLargestNumberToTheRight(std::vector<int>& nums) {
    std::vector<int> res(nums.size(), 0);
    std::vector<int> stack;
    // Find the next largest number of each element, starting with the 
    // rightmost element.
    for (int i = nums.size() - 1; i >= 0; i--) {
        // Pop values from the top of the stack until the current
        // value's next largest number is at the top.
        while (!stack.empty() && stack.back() <= nums[i]) {
            stack.pop_back();
        }
        // Record the current value's next largest number, which is at
        // the top of the stack. If the stack is empty, record -1.
        res[i] = !stack.empty() ? stack.back() : -1;
        stack.push_back(nums[i]);
    }
    return res;
}