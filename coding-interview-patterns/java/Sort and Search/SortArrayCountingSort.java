import java.util.Arrays;

public class SortArrayCountingSort {
    public int[] sortArrayCountingSort(int[] nums) {
        if (nums == null || nums.length == 0) return nums;
        int[] res = new int[nums.length];
        int max = Arrays.stream(nums).max().getAsInt();
        // Count occurrences of each element in 'nums'.
        int[] counts = new int[max + 1];
        for (int num : nums) {
            counts[num]++;
        }
        // Build the sorted array by appending each index 'i' to it a total 
        // of 'counts[i]' times.
        int idx = 0;
        for (int i = 0; i < counts.length; i++) {
            for (int j = 0; j < counts[i]; j++) {
                res[idx] = i;
                idx++;
            }
        }
        return res;
    }
}
