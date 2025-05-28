fun findTheTargetInARotatedSortedArray(nums: List<Int>, target: Int): Int {
    var left = 0
    var right = nums.size - 1
    while (left < right) {
        val mid = left + (right - left) / 2
        if (nums[mid] == target) {
            return mid
        }
        // If the left subarray [left : mid] is sorted, check if the 
        // target falls in this range. If it does, search the left 
        // subarray. Otherwise, search the right.
        if (nums[left] <= nums[mid]) {
            if (nums[left] <= target && target < nums[mid]) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        // If the right subarray [mid : right] is sorted, check if the
        // target falls in this range. If it does, search the right
        // subarray. Otherwise, search the left.
        } else {
            if (nums[mid] < target && target <= nums[right]) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
    }
    return if (nums.isNotEmpty() && nums[left] == target) left else -1
}
