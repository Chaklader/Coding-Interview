#include <vector>
#include <algorithm>

int neighborhoodBurglaryOptimized(std::vector<int>& houses) {
    if (houses.empty()) {
        return 0;
    }
    if (houses.size() == 1) {
        return houses[0];
    }
    // Initialize the variables with the base cases.
    int prevMaxProfit = std::max(houses[0], houses[1]);
    int prevPrevMaxProfit = houses[0];
    for (int i = 2; i < houses.size(); i++) {
        int currMaxProfit = std::max(prevMaxProfit, houses[i] + prevPrevMaxProfit);
        // Update the values for the next iteration.
        prevPrevMaxProfit = prevMaxProfit;
        prevMaxProfit = currMaxProfit;
    }
    return prevMaxProfit;
}