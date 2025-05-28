fun combinationsOfSumK(nums: List<Int>, target: Int): List<List<Int>> {
    val res = mutableListOf<List<Int>>()
    dfs(mutableListOf(), 0, nums, target, res)
    return res
}

fun dfs(
        combination: MutableList<Int>,
        startIndex: Int,
        nums: List<Int>,
        target: Int,
        res: MutableList<List<Int>>
) {
    // Termination condition: If the target is equal to 0, we found a combination
    // that sums to 'k'.
    if (target == 0) {
        res.add(ArrayList(combination))
        return
    }
    // Termination condition: If the target is less than 0, no more valid
    // combinations can be created by adding it to the current combination.
    if (target < 0) {
        return
    }
    // Starting from start_index, explore all combinations after adding nums[i].
    for (i in startIndex until nums.size) {
        // Add the current number to create a new combination.
        combination.add(nums[i])
        // Recursively explore all paths that branch from this new combination.
        dfs(combination, i, nums, target - nums[i], res)
        // Backtrack by removing the number we just added.
        combination.removeAt(combination.size - 1)
    }
}
