#include <vector>

std::vector<int> hammingWeightsOfIntegersDp(int n) {
    // Base case: the number of set bits in 0 is just 0.
    // We set dp[0] to 0 by initializing the entire DP array to 0.
    std::vector<int> dp(n + 1, 0);
    for (int x = 1; x <= n; x++) {
        // 'dp[x]' is obtained using the result of 'dp[x >> 1]', plus 
        // the LSB of 'x'.
        dp[x] = dp[x >> 1] + (x & 1);
    }
    return dp;
}