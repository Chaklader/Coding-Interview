fun findAllSubsets(nums: List<Int>): List<List<Int>> {
    val res = mutableListOf<List<Int>>()
    backtrack(0, mutableListOf(), nums, res)
    return res
}

fun backtrack(i: Int, currSubset: MutableList<Int>, nums: List<Int>, res: MutableList<List<Int>>) {
    // Base case: if all elements have been considered, add the
    // current subset to the output.
    if (i == nums.size) {
        res.add(currSubset.toList())
        return
    }
    // Include the current element and recursively explore all paths
    // that branch from this subset.
    currSubset.add(nums[i])
    backtrack(i + 1, currSubset, nums, res)
    // Exclude the current element and recursively explore all paths
    // that branch from this subset.
    currSubset.removeAt(currSubset.size - 1)
    backtrack(i + 1, currSubset, nums, res)
}
