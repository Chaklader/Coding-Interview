from typing import Dict, List


def min_coin_combination_top_down(coins: List[int], target: int) -> int:
    res = top_down_dp(coins, target, {})
    return -1 if res == float('inf') else res

def top_down_dp(coins: List[int], target: int, memo: Dict[int, int]) -> int:
    # Base case: if the target is 0, then 0 coins are needed to reach 
    # it.
    if target == 0:
        return 0
    if target in memo:
        return memo[target]
    # Initialize 'min_coins' to a large number.
    min_coins = float('inf')
    for coin in coins:
        # Avoid negative targets.
        if coin <= target:
            # Calculate the minimum number of coins needed if we use
            # the current coin.
            min_coins = min(min_coins, 1 + top_down_dp(coins, target - coin, memo))
    memo[target] = min_coins
    return memo[target]
