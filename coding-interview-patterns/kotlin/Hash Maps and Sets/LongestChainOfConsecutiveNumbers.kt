fun longestChainOfConsecutiveNumbers(nums: List<Int>): Int {
    if (nums.isEmpty()) {
        return 0
    }
    val numSet = nums.toSet()
    var longestChain = 0
    for (num in numSet) {
        // If the current number is the smallest number in its chain, search for
        // the length of its chain.
        if (num - 1 !in numSet) {
            var currentNum = num
            var currentChain = 1
            // Continue to find the next consecutive numbers in the chain.
            while (currentNum + 1 in numSet) {
                currentNum++
                currentChain++
            }
            longestChain = maxOf(longestChain, currentChain)
        }
    }
    return longestChain
}
