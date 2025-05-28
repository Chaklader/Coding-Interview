import java.util.HashMap;
import java.util.Map;

public class PairSumUnsortedTwoPass {
    public int pairSumUnsortedTwoPass(int[] nums) {
        Map<Integer, Integer> numMap = new HashMap<>();
        // First pass: Populate the hash map with each number and its 
        // index.
        for (int i = 0; i < nums.length; i++) {
            numMap.put(nums[i], i);
        }
        // Second pass: Check for each number's complement in the hash map.
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement) && numMap.get(complement) != i) {
                return new int[]{i, numMap.get(complement)};
            }
        }
        return new int[]{};
    }
}
