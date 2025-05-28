public class KthLargestIntegerQuickselect {
    public int kthLargestIntegerQuickselect(int[] nums, int k) {
        return quickselect(nums, 0, nums.length - 1, k);
    }

    private int quickselect(int[] nums, int left, int right, int k) {
        int n = nums.length;
        if (left >= right) return nums[left];
        int randomIndex = left + (int)(Math.random() * (right - left + 1));
        swap(nums, randomIndex, right);
        int pivotIndex = partition(nums, left, right);
        // If the pivot comes before 'n - k', the ('n - k')th smallest 
        // integer is somewhere to its right. Perform quickselect on the 
        // right part.
        if (pivotIndex < n - k) return quickselect(nums, pivotIndex + 1, right, k);
        // If the pivot comes after 'n - k', the ('n - k')th smallest integer
        // is somewhere to its left. Perform quickselect on the left part.
        else if (pivotIndex > n - k) return quickselect(nums, left, pivotIndex - 1, k);
        // If the pivot is at index 'n - k', it's the ('n - k')th smallest
        // integer.
        else return nums[pivotIndex];
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int lo = left;
        for (int i = left; i < right; i++) {
            if (nums[i] < pivot) {
                swap(nums, lo, i);
                lo++;
            }
        }
        swap(nums, lo, right);
        return lo;
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}