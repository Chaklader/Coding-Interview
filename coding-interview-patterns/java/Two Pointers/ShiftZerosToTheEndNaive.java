import java.util.Arrays;

public class ShiftZerosToTheEndNaive {
    public void shiftZerosToTheEndNaive(int[] nums) {
        int[] temp = new int[nums.length];
        int i = 0;
        // Add all non-zero elements to the left of 'temp'.
        for (int num : nums) {
            if (num != 0) {
                temp[i] = num;
                i++;
            }
        }
        // Copy 'temp' array to 'nums' array
        // Note: `System.arraycopy` Copies an array from the specified source array, beginning at the specified position, to the specified position of the destination array.
        System.arraycopy(temp, 0, nums, 0, nums.length);
    }

}
