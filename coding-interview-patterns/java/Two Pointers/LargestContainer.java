public class LargestContainer {
    public int largestContainer(int[] height) {
        int maxWater = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            // Calculate the water contained between the current pair of lines.
            int water = Math.min(height[left], height[right]) * (right - left);
            maxWater = Math.max(maxWater, water);
            // Move the pointers inward, always moving the pointer at the shorter line.
            // If both lines have the same height, move both pointers inward.
            if (height[left] < height[right]) {
                left++;
            } else if (height[left] > height[right]) {
                right--;
            } else {
                left++;
                right--;
            }
        }
        return maxWater;
    }
}
