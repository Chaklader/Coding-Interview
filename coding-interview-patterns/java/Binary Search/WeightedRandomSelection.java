public class WeightedRandomSelection {
    int[] prefixSum;

    public WeightedRandomSelection(int[] weights) {
        this.prefixSum = new int[weights.length];
        for (int i = 0; i < weights.length; i++) {
            prefixSum[i] = i == 0 ? weights[i] : prefixSum[i-1] + weights[i];
        }
    }

    private int select() {
        // Pick a random target between 1 and the largest endpoint on the number 
        // line.
        int target = (int)(Math.random() * prefixSum[prefixSum.length - 1]) + 1;
        int left = 0;
        int right = prefixSum.length - 1;
        // Perform lower-bound binary search to find which endpoint (i.e., prefix 
        // sum value) corresponds to the target.
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (prefixSum[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
