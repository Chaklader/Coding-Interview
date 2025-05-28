import java.util.Arrays;

public class CuttingWood {
    public int cuttingwood(int[] heights, int k) {
        int left = 0;
        int right = Arrays.stream(heights).max().getAsInt();
        while (left < right) {
            // Bias the midpoint to the right during the upper-bound binary 
            // search.
            int mid = left + (right - left) / 2 + 1;
            if (cutsEnoughWood(mid, k, heights)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    // Determine if the current value of 'H' cuts at least 'k' meters of 
    // wood.
    private boolean cutsEnoughWood(int H, int k, int[] heights) {
        int woodCollected = 0;
        for (int height : heights) {
            if (height > H) {
                woodCollected += (height - H);
            }
        }
        return woodCollected >= k;
    }
}
