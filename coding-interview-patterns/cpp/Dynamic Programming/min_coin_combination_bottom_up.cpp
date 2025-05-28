#include <vector>
#include <algorithm>
#include <limits>

int minCoinCombinationBottomUp(std::vector<int>& coins, int target) {
    // The DP array will store the minimum number of coins needed for each amount.
    // Set each element to a large number initially.
    std::vector<int> dp(target + 1, std::numeric_limits<int>::max());
    // Base case: if the target is 0, then 0 coins are needed.
    dp[0] = 0;
    // Update the DP array for all target amounts greater than 0.
    for (int t = 1; t <= target; t++) {
        for (int coin : coins) {
            if (coin <= t && dp[t - coin] != std::numeric_limits<int>::max()) {
                dp[t] = std::min(dp[t], 1 + dp[t - coin]);
            }
        }
    }
    return dp[target] != std::numeric_limits<int>::max() ? dp[target] : -1;
}