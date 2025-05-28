fun jumpToTheEnd(nums: List<Int>): Boolean {
    // Set the initial destination to the last index in the array.
    var destination = nums.size - 1
    // Traverse the array in reverse to see if the destination can be
    // reached by earlier indexes.
    for (i in nums.size - 2 downTo 0) {
        // If we can reach the destination from the current index,
        // set this index as the new destination.
        if (i + nums[i] >= destination) {
            destination = i
        }
    }
    // If the destination is index 0, we can jump to the end from index
    // 0.
    return destination == 0
}
