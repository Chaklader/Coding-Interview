#include <unordered_map>

int climbingStairsTopDown(int n) {
    std::unordered_map<int, int> memo;
    return climbingStairsTopDownHelper(n, memo);
}

int climbingStairsTopDownHelper(int n, std::unordered_map<int, int>& memo) {
    // Base cases: With a 1-step staircase, there's only one way to 
    // climb it. With a 2-step staircase, there are two ways to climb it.
    if (n <= 2) {
        return n;
    }
    if (memo.count(n)) {
        return memo[n];
    }
    // The number of ways to climb to the n-th step is equal to the sum 
    // of the number of ways to climb to step n - 1 and to n - 2.
    memo[n] = climbingStairsTopDownHelper(n - 1, memo) + climbingStairsTopDownHelper(n - 2, memo);
    return memo[n];
}