from typing import List


def find_the_target_in_a_rotated_sorted_array(nums: List[int], target: int) -> int:
   left, right = 0, len(nums) - 1
   while left < right:
       mid = (left + right) // 2
       if nums[mid] == target:
           return mid
       # If the left subarray [left : mid] is sorted, check if the 
       # target falls in this range. If it does, search the left 
       # subarray. Otherwise, search the right.
       elif nums[left] <= nums[mid]:
           if nums[left] <= target < nums[mid]:
               right = mid - 1
           else:
               left = mid + 1
       # If the right subarray [mid : right] is sorted, check if the
       # target falls in this range. If it does, search the right
       # subarray. Otherwise, search the left.
       else:
           if nums[mid] < target <= nums[right]:
               left = mid + 1
           else:
               right = mid - 1
   # If the target is found in the array, return it's index. Otherwise,
   # return -1.
   return left if nums and nums[left] == target else -1
