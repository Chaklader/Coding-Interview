public class LargestContainerBruteForce {
    public int largestContainerBruteForce(int[] height) {
        int n = height.length;
        int maxWater = 0;
        // Find the maximum amount of water stored between all pairs of lines.
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Calculate the area of the container formed by the lines at indexes i and j.
                int water = Math.min(height[i], height[j]) * (j - i);
                // Update the maximum amount of water stored.
                maxWater = Math.max(maxWater, water);
            }
        }
        return maxWater;
    }
 }
