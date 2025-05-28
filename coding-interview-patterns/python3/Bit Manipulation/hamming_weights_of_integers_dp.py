from typing import List


def hamming_weights_of_integers_dp(n: int) -> List[int]:
    # Base case: the number of set bits in 0 is just 0. We set dp[0] to 
    # 0 by initializing the entire DP array to 0.
    dp = [0] * (n + 1)
    for x in range(1, n + 1):
        # 'dp[x]' is obtained using the result of 'dp[x >> 1]', plus 
        # the LSB of 'x'.
        dp[x] = dp[x >> 1] + (x & 1)
    return dp
