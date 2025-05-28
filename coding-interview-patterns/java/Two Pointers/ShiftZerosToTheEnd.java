public class ShiftZerosToTheEnd {
    public void shiftZerosToTheEnd(int[] nums) {
        // The 'left' pointer is used to position non-zero elements.
        int left = 0;
        // Iterate through the array using a 'right' pointer to locate non-zero elements.
        for (int right = 0; right < nums.length; right++) {
            // If the element at the 'right' pointer is non-zero, swap it with the element at the 'left' pointer.
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                // Increment 'left' since it now points to a position already occupied by a non-zero element.
                left++;
            }
        }
    }
}
