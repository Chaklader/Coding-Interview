func pairSumSorted(nums []int, target int) []int {
	left, right := 0, len(nums)-1
	for left < right {
		sum := nums[left] + nums[right]
		// If the sum is smaller, increment the left pointer, aiming
		// to increase the sum toward the target value.
		if sum < target {
			left++
		} else if sum > target {
			// If the sum is larger, decrement the right pointer, aiming
			// to decrease the sum toward the target value.
			right--
		} else {
			// If the target pair is found, return its indexes.
			return []int{left, right}
		}
	}
	return nil
}
