from typing import List


def maximum_subarray_sum_dp_optimized(nums: List[int]) -> int:
    n = len(nums)
    if n == 0:
        return 0
    current_sum = nums[0]
    max_sum = nums[0]
    for i in range(1, n):
        current_sum = max(nums[i], current_sum + nums[i])
        max_sum = max(max_sum, current_sum)
    return max_sum