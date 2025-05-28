fun climbingStairsTopDown(n: Int): Int {
    val memo = hashMapOf<Int, Int>()
    return climbingStairsTopDownHelper(n, memo)
}

fun climbingStairsTopDownHelper(n: Int, memo: HashMap<Int, Int>): Int {
    // Base cases: With a 1-step staircase, there's only one way to
    // climb it. With a 2-step staircase, there are two ways to climb it.
    if (n <= 2) {
        return n
    }
    if (memo[n] != 0) {
        return memo[n]!!
    }
    // The number of ways to climb to the n-th step is equal to the sum
    // of the number of ways to climb to step n - 1 and to n - 2.
    memo[n] = climbingStairsTopDownHelper(n - 1, memo) + climbingStairsTopDownHelper(n - 2, memo)
    return memo[n]!!
}
