public class DutchNationalFlag {
    public void dutchNationalFlag(int[] nums) {
        int i = 0;
        int left = 0;
        int right = nums.length - 1;
        while (i <= right) {
            // Swap 0s with the element at the left pointer.
            if (nums[i] == 0) {
                swap(nums, i, left);
                left++;
                i++;
            }
            // Swap 2s with the element at the right pointer.
            else if (nums[i] == 2) {
                swap(nums, i, right);
                right--;
            } else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
