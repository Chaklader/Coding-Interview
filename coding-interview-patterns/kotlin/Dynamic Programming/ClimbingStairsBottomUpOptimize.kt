fun climbingStairsBottomUpOptimized(n: Int): Int {
    if (n <= 2) {
        return n
    }
    // Set 'oneStepBefore' and 'twoStepsBefore' as the base cases.
    var oneStepBefore = 2
    var twoStepsBefore = 1
    for (i in 3..n) {
        // Calculate the number of ways to reach the current step.
        val current = oneStepBefore + twoStepsBefore
        // Update the values for the next iteration.
        twoStepsBefore = oneStepBefore
        oneStepBefore = current
    }
    return oneStepBefore
}
