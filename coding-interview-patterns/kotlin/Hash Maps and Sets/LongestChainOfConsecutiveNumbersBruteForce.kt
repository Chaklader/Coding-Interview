fun longestChainOfConsecutiveNumbersBruteForce(nums: List<Int>): Int {
    if (nums.isEmpty()) {
        return 0
    }
    var longestChain = 0
    // Look for chains of consecutive numbers that start from each number.
    for (num in nums) {
        var currentNum = num
        var currentChain = 1
        // Continue to find the next consecutive numbers in the chain.
        while (currentNum + 1 in nums) {
            currentNum++
            currentChain++
        }
        longestChain = maxOf(longestChain, currentChain)
    }
    return longestChain
}
