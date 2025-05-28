import java.util.*;

public class TripletSumBruteForce {
    public List<List<Integer>> tripletSumBruteForce(int[] nums) {
        int n = nums.length;
        // Use a hash set to ensure we don't add duplicate triplets.
        Set<List<Integer>> triplets = new HashSet<>();

        // Iterate through the indexes of all triplets.
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        // Sort the triplet before including it in the hash set.
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(triplet);
                        triplets.add(triplet);
                    }
                }
            }
        }
        // Convert the HashSet to a List of Lists.
        return new ArrayList<>(triplets);
    }
}
