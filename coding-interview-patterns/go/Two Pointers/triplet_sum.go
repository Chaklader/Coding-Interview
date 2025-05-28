func tripletSum(nums []int) [][]int {
	triplets := [][]int{}
	sort.Ints(nums)

	for i := 0; i < len(nums); i++ {
		// Optimization: triplets consisting of only positive numbers
		// will never sum to 0.

		if nums[i] > 0 {
			break
		}

		// To avoid duplicate triplets, skip 'a' if it's the same as
		// the previous number.
		if i > 0 && nums[i] == nums[i-1] {
			continue
		}

		// Find all pairs that sum to a target of '-a' (-nums[i]).
		pairs := pairSumSortedAllPairs(nums, i+1, -nums[i])
		for _, pair := range pairs {
			triplets = append(triplets, []int{nums[i], pair[0], pair[1]})
		}
	}

	return triplets
}

func pairSumSortedAllPairs(nums []int, start int, target int) [][]int {
	pairs := [][]int{}
	left, right := start, len(nums)-1
	for left < right {
		sum := nums[left] + nums[right]
		if sum == target {
			pairs = append(pairs, []int{nums[left], nums[right]})
			left++
			// To avoid duplicate '[b, c]' pairs, skip 'b' if it's the
			// same as the previous number.
			for left < right && nums[left] == nums[left-1] {
				left++
			}
		} else if sum < target {
			left++
		} else {
			right--
		}
	}

	return pairs
}
