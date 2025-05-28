#include <vector>                  
#include <unordered_map>           

int geometricSequenceTriplets(std::vector<int>& nums, int r) {
    // Use 'unordered_map' which initializes non-existent keys to 0
    // for frequency counting. 
    std::unordered_map<int, int> leftMap;   
    std::unordered_map<int, int> rightMap;  
    int count = 0;  
    // Populate 'right_map' with the frequency of each element in the array.
    for (const auto& x : nums) {
        rightMap[x]++;
    }
    // Search for geometric triplets that have x as the center.
    for (const auto& x : nums) {
        // Decrement the frequency of x in 'right_map' since x is now being
        // processed and is no longer to the right.
        rightMap[x]--;
        if (r != 0 && x % r == 0) {
            count += leftMap[x / r] * rightMap[x * r];
        }
        // Increment the frequency of x in 'left_map' since it'll be a part of the
        // left side of the array once we iterate to the next value of x.
        leftMap[x]++;
    }
    return count;
}