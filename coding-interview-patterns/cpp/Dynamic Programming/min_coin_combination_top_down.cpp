#include <vector>
#include <unordered_map>
#include <limits>

int minCoinCombinationTopDown(std::vector<int>& coins, int target) {
    std::unordered_map<int, int> memo;
    int res = topDownDp(coins, target, memo);
    return res == std::numeric_limits<int>::max() ? -1 : res;
}

int topDownDp(std::vector<int>& coins, int target, std::unordered_map<int, int>& memo) {
    // Base case: if the target is 0, then 0 coins are needed to reach it.
    if (target == 0) {
        return 0;
    }
    if (memo.find(target) != memo.end()) {
        return memo[target];
    }
    // Initialize 'minCoins' to a large number.
    int minCoins = std::numeric_limits<int>::max();
    for (int coin : coins) {
        // Avoid negative targets.
        if (coin <= target) {
            // Calculate the minimum number of coins needed if we use the current coin.
            int result = topDownDp(coins, target - coin, memo);
            if (result != std::numeric_limits<int>::max() && result + 1 < minCoins) {
                minCoins = result + 1;
            }
        }
    }
    memo[target] = minCoins;
    return memo[target];
}