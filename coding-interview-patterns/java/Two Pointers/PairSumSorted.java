import java.util.Arrays;

public class PairSumSorted {
    public int[] pairSumSorted(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            // If the sum is smaller, increment the left pointer, aiming to increase the sum toward the target value.
            if (sum < target) {
                left++;
            } else if (sum > target) { // If the sum is larger, decrement the right pointer, aiming to decrease the sum toward the target value.
                right--;
            } else { // If the target pair is found, return its indexes.
                return new int[] {left, right};
            }
        }
        return new int[] {};
    }
}
