import java.util.HashSet;
import java.util.Set;

public class LongestChainOfConsecutiveNumbers {
    public int longestChainOfConsecutiveNumbers(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int longestChain = 0;
        for (int num : numSet) {
            // If the current number is the smallest number in its chain, search for
            // the length of its chain.
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentChain = 1;
                // Continue to find the next consecutive numbers in the chain.
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentChain++;
                }
                longestChain = Math.max(longestChain, currentChain);
            }
        }
        return longestChain;
    }
}
