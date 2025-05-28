from typing import List


def sort_array_counting_sort(nums: List[int]) -> List[int]:
    if not nums:
        return []
    res = []
    # Count occurrences of each element in 'nums'.
    counts = [0] * (max(nums) + 1)
    for num in nums:
        counts[num] += 1
    # Build the sorted array by appending each index 'i' to it a total 
    # of 'counts[i]' times.
    for i, count in enumerate(counts):
        res.extend([i] * count)
    return res
