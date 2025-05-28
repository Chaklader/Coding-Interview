fun dutchNationalFlag(nums: MutableList<Int>) {
    var i = 0
    var left = 0
    var right = nums.size - 1
    while (i <= right) {
        // Swap 0s with the element at the left pointer.
        if (nums[i] == 0) {
            nums[i] = nums[left].also { nums[left] = nums[i] }
            left++
            i++
        // Swap 2s with the element at the right pointer.
        } else if (nums[i] == 2) {
            nums[i] = nums[right].also { nums[right] = nums[i] }
            right--
        } else {
            i++
        }
    }
}
