fun candies(ratings: List<Int>): Int {
    val n = ratings.size
    // Ensure each child starts with 1 candy.
    val candies = IntArray(n) { 1 }
    // First pass: for each child, ensure the child has more candies
    // than their left-side neighbor if the current child's rating is
    // higher.
    for (i in 1 until n) {
        if (ratings[i] > ratings[i - 1]) {
            candies[i] = candies[i - 1] + 1
        }
    }
    // Second pass: for each child, ensure the child has more candies
    // than their right-side neighbor if the current child's rating is
    // higher.
    for (i in n - 2 downTo 0) {
        if (ratings[i] > ratings[i + 1]) {
            // If the current child already has more candies than their
            // right-side neighbor, keep the higher amount.
            candies[i] = maxOf(candies[i], candies[i + 1] + 1)
        }
    }
    return candies.sum()
}
