public class SortArrayQuicksortOptimized {
    public int[] sortArray(int[] nums) {
        quicksortOptimized(nums, 0, nums.length - 1);
        return nums;
    }

    private void quicksortOptimized(int[] nums, int left, int right) {
        if (left >= right) return;
        // Choose a pivot at a random index.
        // Math.random() generate a double in [0.0, 1.0)
        // Scale the range from [0.0, 1.0) to [0, right - left + 1)
        int randomIndex = left + (int)(Math.random() * (right - left + 1));
        // Swap the randomly chosen pivot with the rightmost element to 
        // position the pivot at the rightmost index.
        swap(nums, randomIndex, right);
        int pivotIndex = partition(nums, left, right);
        quicksortOptimized(nums, left, pivotIndex - 1);
        quicksortOptimized(nums, pivotIndex + 1, right);
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int lo = left;
        // Move all numbers less than the pivot to the left, which
        // consequently positions all numbers greater than or equal to the
        // pivot to the right.
        for (int i = left; i < right; i++) {
            if (nums[i] < pivot) {
                swap(nums, lo, i);
                lo++;
            }
        }
        // After partitioning, 'lo' will be positioned where the pivot should
        // be. So, swap the pivot number with the number at the 'lo' pointer.
        swap(nums, lo, right);
        return lo;
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
