#include <vector>
#include <algorithm>

int cuttingWood(std::vector<int>& heights, int k) {
    int left = 0;
    int right = *std::max_element(heights.begin(), heights.end());
    while (left < right) {
        // Bias the midpoint to the right during the upper-bound binary 
        // search.
        int mid = (left + right) / 2 + 1;
        if (cutsEnoughWood(mid, k, heights)) {
            left = mid;
        } else {
            right = mid - 1;
        }
    }
    return right;
}

// Determine if the current value of 'H' cuts at least 'k' meters of 
// wood.
bool cutsEnoughWood(int H, int k, std::vector<int>& heights) {
    int woodCollected = 0;
    for (int height : heights) {
        if (height > H) {
            woodCollected += (height - H);
        }
    }
    return woodCollected >= k;
}