#include <vector>
#include <random> 

class WeightedRandomSelection {
public:
    std::vector<int> prefixSums;
    int totalWeight;
    std::mt19937 rng;
    std::uniform_int_distribution<int> dist;
    WeightedRandomSelection(std::vector<int>& weights) : rng(std::random_device{}()) {
        prefixSums.resize(weights.size());
        prefixSums[0] = weights[0];
        for (int i = 1; i < weights.size(); i++) {
            prefixSums[i] = prefixSums[i - 1] + weights[i];
        }
        totalWeight = prefixSums.back();
        dist = std::uniform_int_distribution<int>(1, totalWeight);
    }
    
    int select() {
        // Pick a random target between 1 and the largest endpoint on the number 
        // line.
        int target = dist(rng);
        int left = 0, right = prefixSums.size() - 1;
        // Perform lower-bound binary search to find which endpoint (i.e., prefix 
        // sum value) corresponds to the target. 
        while (left < right) {
            int mid = (left + right) / 2;
            if (prefixSums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
};