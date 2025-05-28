func largestContainer(heights []int) int {
	maxWater := 0
	left, right := 0, len(heights)-1

	for left < right {
		// Calculate the water contained between the current pair of
		// lines.
		water := min(heights[left], heights[right]) * (right - left)
		maxWater = max(maxWater, water)
		// Move the pointers inward, always moving the pointer at the
		// shorter line. If both lines have the same height, move both
		// pointers inward.
		if heights[left] < heights[right] {
			left++
		} else if heights[left] > heights[right] {
			right--
		} else {
			left++
			right--
		}
	}

	return maxWater
}
