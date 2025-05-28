from typing import List


def min_coin_combination_bottom_up(coins: List[int], target: int) -> int:
    # The DP array will store the minimum number of coins needed for 
    # each amount. Set each element to a large number initially.
    dp = [float('inf')] * (target + 1)
    # Base case: if the target is 0, then 0 coins are needed.
    dp[0] = 0
    # Update the DP array for all target amounts greater than 0.
    
    for t in range(1, target + 1):
        for coin in coins:
            if coin <= t:
                dp[t] = min(dp[t], 1 + dp[t - coin])
    return dp[target] if dp[target] != float('inf') else -1
