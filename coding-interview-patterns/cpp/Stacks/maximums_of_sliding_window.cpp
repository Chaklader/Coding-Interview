#include <vector>
#include <deque>

std::vector<int> maximumsOfSlidingWindow(std::vector<int>& nums, int k) {
    std::vector<int> res;
    std::deque<std::pair<int, int>> dq;
    int left = 0, right = 0;
    while (right < nums.size()) {
        // 1) Ensure the values of the deque maintain a monotonic decreasing order
        // by removing candidates <= the current candidate.
        while (!dq.empty() && dq.back().first <= nums[right]) {
            dq.pop_back();
        }
        // 2) Add the current candidate.
        dq.push_back(std::make_pair(nums[right], right));
        // If the window is of length 'k', record the maximum of the window.
        if (right - left + 1 == k) {
            // 3) Remove values whose indexes occur outside the window.
            if (!dq.empty() && dq.front().second < left) {
                dq.pop_front();
            }
            // The maximum value of this window is the leftmost value in the 
            // deque.
            res.push_back(dq.front().first);
            // Slide the window by advancing both 'left' and 'right'. The right  
            // pointer always gets advanced so we just need to advance 'left'.
            left++;
        }
        right++;
    }
    return res;
}