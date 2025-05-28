#include <vector>
#include <numeric>

int gasStations(std::vector<int>& gas, std::vector<int>& cost) {
    // If the total gas is less than the total cost, completing the
    // circuit is impossible.
    if (std::accumulate(gas.begin(), gas.end(), 0) < std::accumulate(cost.begin(), cost.end(), 0)) {
        return -1;
    }
    int start = 0;
    int tank = 0;
    for (int i = 0; i < gas.size(); i++) {
        tank += gas[i] - cost[i];
        // If our tank has negative gas, we cannot continue through the 
        // circuit from the current start point, nor from any station 
        // before or including the current station 'i'.
        if (tank < 0) {
            // Set the next station as the new start point and reset the 
            // tank.
            start = i + 1;
            tank = 0;
        }
    }
    return start;
}