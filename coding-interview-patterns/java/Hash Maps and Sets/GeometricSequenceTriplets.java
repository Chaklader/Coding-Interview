import java.util.HashMap;
import java.util.Map;

public class GeometricSequenceTriplets {
    public int geometricSequenceTriplets(int[] nums, int r) {
        // The default value of 0 is returned when 
        // accessing a key that doesn’t exist in the hash map.
        Map<Integer, Integer> leftMap = new HashMap<>();
        Map<Integer, Integer> rightMap = new HashMap<>();
        int count = 0;
        // Populate 'rightMap' with the frequency of each element in the array.
        for (int x : nums) {
            rightMap.put(x, rightMap.getOrDefault(x, 0) + 1);
        }
        // Search for geometric triplets that have x as the center.
        for (int x : nums) {
            // Decrement the frequency of x in 'rightMap' since x is now being
            // processed and is no longer to the right.
            rightMap.put(x, rightMap.get(x) - 1);
            if (x % r == 0) {
                count += leftMap.getOrDefault(x / r, 0) * rightMap.getOrDefault(x * r, 0);
            }
            // Increment the frequency of x in 'left_map' since it'll be a part of the
            // left side of the array once we iterate to the next value of x.
            leftMap.put(x, leftMap.getOrDefault(x, 0) + 1);
        }
        return count;
    }
}
