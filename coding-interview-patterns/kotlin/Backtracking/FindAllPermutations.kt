fun findAllPermutations(nums: List<Int>): List<List<Int>> {
    val res = mutableListOf<List<Int>>()
    backtrack(nums, mutableListOf(), mutableSetOf(), res)
    return res
}

fun backtrack(
        nums: List<Int>,
        candidate: MutableList<Int>,
        used: MutableSet<Int>,
        res: MutableList<List<Int>>
) {
    // If the current candidate is a complete permutation, add it to the
    // result.
    if (candidate.size == nums.size) {
        res.add(candidate.toList())
        return
    }
    for (num in nums) {
        if (num !in used) {
            // Add 'num' to the current permutation and mark it as used.
            candidate.add(num)
            used.add(num)
            // Recursively explore all branches using the updated
            // permutation candidate.
            backtrack(nums, candidate, used, res)
            // Backtrack by reversing the changes made.
            candidate.removeAt(candidate.size - 1)
            used.remove(num)
        }
    }
}
