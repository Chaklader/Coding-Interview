fun shiftZerosToTheEnd(nums: IntArray) {
    // The 'left' pointer is used to position non-zero elements.
    var left = 0
    // Iterate through the array using a 'right' pointer to locate non-zero
    // elements.
    for (right in nums.indices) {
        if (nums[right] != 0) {
            // Swap element
            nums[left] = nums[right].also { nums[right] = nums[left] }
            // Increment 'left' since it now points to a position already occupied
            // by a non-zero element.
            left++
        }
    }
}
