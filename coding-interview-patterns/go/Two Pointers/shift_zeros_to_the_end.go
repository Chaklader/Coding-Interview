func shiftZerosToTheEnd(nums []int) {
	// The 'left' pointer is used to position non-zero elements.
	left := 0
	// Iterate through the array using a 'right' pointer to locate non-zero
	// elements.
	for right := 0; right < len(nums); right++ {
		if nums[right] != 0 {
			nums[left], nums[right] = nums[right], nums[left]
			// Increment 'left' since it now points to a position already occupied
			// by a non-zero element.
			left++
		}
	}
}
