from typing import List


def k_sum_subarrays_optimized(nums: List[int], k: int) -> int:
    count = 0
    # Initialize the map with 0 to handle subarrays that sum to 'k' 
    # from the start of the array.
    prefix_sum_map = {0: 1}
    curr_prefix_sum = 0
    for num in nums:
        # Update the running prefix sum by adding the current number.
        curr_prefix_sum += num
        # If a subarray with sum 'k' exists, increment 'count' by the 
        # number of times it has been found.
        if curr_prefix_sum - k in prefix_sum_map:
            count += prefix_sum_map[curr_prefix_sum - k]
        # Update the frequency of 'curr_prefix_sum' in the hash map.
        freq = prefix_sum_map.get(curr_prefix_sum, 0)
        prefix_sum_map[curr_prefix_sum] = freq + 1
    return count
